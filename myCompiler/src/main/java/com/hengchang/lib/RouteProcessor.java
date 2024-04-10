package com.hengchang.lib;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

public class RouteProcessor extends AbstractProcessor {

    Filer filer;
    Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        filer = processingEnv.getFiler();
        messager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        System.out.println("============== My process ==============");
        testJavaPoet();
        testCreateFile();
        return false;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return super.getSupportedAnnotationTypes();
    }

    private void testJavaPoet() {

        ClassName AppCompatActivity = ClassName.get("androidx.appcompat.app", "AppCompatActivity");
        ClassName bundle = ClassName.get("android.os", "Bundle");
        ClassName Nullable = ClassName.get("androidx.annotation", "Nullable");
        ClassName Override = ClassName.get("java.lang", "Override");
        //创建一个方法参数
        ParameterSpec savedInstanceState = ParameterSpec.builder(bundle, "savedInstanceState")
                .addAnnotation(Nullable)
                .build();
        //创建一个方法
        MethodSpec onCreate = MethodSpec.methodBuilder("onCreate")
                .addAnnotation(Override)
                .addModifiers(Modifier.PROTECTED)
                .returns(TypeName.VOID)
                .addParameter(savedInstanceState)
                .addStatement("super.onCreate(savedInstanceState)")
                .build();
        //创建一个类
        TypeSpec testActivity = TypeSpec.classBuilder("TestActivity")
                .addModifiers(Modifier.PUBLIC)
                .addMethod(onCreate)
                .superclass(AppCompatActivity)
                .build();

        //创建文件
        JavaFile file = JavaFile.builder("com.whl215.aptdemo", testActivity).build();
        try {
            file.writeTo(filer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

/**
 *原生api创建类
 */
private void testCreateFile() {
    BufferedWriter writer = null;
    try {
        JavaFileObject sourceFile = filer.createSourceFile("com.xxx.TestActivity");
        writer = new BufferedWriter(sourceFile.openWriter());

        writer.write("package com.whl215.aptdemo;\n\n");
        writer.write("import android.os.Bundle;\n\n");
        writer.write("import androidx.annotation.Nullable;\n");
        writer.write("import androidx.appcompat.app.AppCompatActivity;\n");
        writer.write("public class TestActivity extends AppCompatActivity {\n\n");
        writer.write("      @Override\n");
        writer.write("      protected void onCreate(@Nullable Bundle savedInstanceState) {\n");
        writer.write("          super.onCreate(savedInstanceState);\n");
        writer.write("    }\n");
        writer.write("}");
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}


    @Override
    public SourceVersion getSupportedSourceVersion() {
        return super.getSupportedSourceVersion();
    }
}
