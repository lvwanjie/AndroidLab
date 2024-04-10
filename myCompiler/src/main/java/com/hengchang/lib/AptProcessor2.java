package com.hengchang.lib;

import com.lwj.myannotation.MyBindView;

import java.io.IOException;
import java.io.Writer;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

@SupportedAnnotationTypes("com.ldx.annotationlib.BindView")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class AptProcessor2 extends AbstractProcessor {

    private Filer mFilerUtils;       // 文件管理工具类，可以用于生成java源文件
    private Types mTypesUtils;    // 类型处理工具类，
    private Elements mElementsUtils;  // Element处理工具类，获取Element的信息
    private Messager mMessager;  //用于打印信息

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        mFilerUtils = processingEnv.getFiler();
        mTypesUtils = processingEnv.getTypeUtils();
        mElementsUtils = processingEnv.getElementUtils();
        mMessager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        if (set != null && set.size() > 0){

            Set<? extends Element>  elements = roundEnvironment.getElementsAnnotatedWith(MyBindView.class);
            for (Element element : elements) {
                //已知是一个成员变量的注解，所以可以直接强转
                VariableElement variableElement = (VariableElement) element;
                //3.获取注解的成员变量名
                String bindViewFiledName = variableElement.getSimpleName().toString();
                //3.获取注解的成员变量类型
                String bindViewFiledClassType = variableElement.asType().toString();

                //变量名
                mMessager.printMessage(Diagnostic.Kind.NOTE,"aptprocessor     "+variableElement.getSimpleName());
                //是字段类型
                mMessager.printMessage(Diagnostic.Kind.NOTE,"aptprocessor     "+variableElement.getKind().toString());
                MyBindView bindAnnotation = variableElement.getAnnotation(MyBindView.class);
                //此处是id值
                mMessager.printMessage(Diagnostic.Kind.NOTE,"aptprocessor     "+bindAnnotation.value()+"");

                TypeElement enclosingElement = (TypeElement) variableElement.getEnclosingElement();

                //类名
                mMessager.printMessage(Diagnostic.Kind.NOTE,"aptprocessor     "+enclosingElement.getSimpleName());
                //全类名
                mMessager.printMessage(Diagnostic.Kind.NOTE,"aptprocessor     "+enclosingElement.getQualifiedName());
                //Class
                mMessager.printMessage(Diagnostic.Kind.NOTE,"aptprocessor     "+enclosingElement.getKind().toString());
                //包名
                mMessager.printMessage(Diagnostic.Kind.NOTE,"aptprocessor     "+mElementsUtils.getPackageOf(enclosingElement).asType().toString());
                createFile(enclosingElement, bindViewFiledClassType, bindViewFiledName, bindAnnotation.value());
            }

            return true;
        }
        return false;
    }

    private void createFile(TypeElement enclosingElement, String bindViewFiledClassType, String bindViewFiledName, int id) {
        String pkName = mElementsUtils.getPackageOf(enclosingElement).getQualifiedName().toString();
        String packName = mElementsUtils.getPackageOf(enclosingElement).asType().toString();
        String className = enclosingElement.getSimpleName().toString();
        try {
            JavaFileObject jfo = mFilerUtils.createSourceFile(pkName + "."+className+ "$ViewBinding", new Element[]{});
            Writer writer = jfo.openWriter();
            writer.write(brewCode(className,pkName, bindViewFiledClassType, bindViewFiledName, id));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String brewCode(String className,String pkName, String bindViewFiledClassType, String bindViewFiledName, int id) {
        StringBuilder builder = new StringBuilder();
        builder.append("package " + pkName + ";\n\n");
        builder.append("public class " + className + "$ViewBinding { \n\n");
        builder.append("public static void main(String[] args){ \n\n");
        String info = String.format("%s %s = findViewById(%d)", bindViewFiledClassType, bindViewFiledName, id);
        builder.append("System.out.println(\"" + info + "\");\n\n");
        builder.append("}\n\n");
        builder.append("}");
        return builder.toString();
    }




}
