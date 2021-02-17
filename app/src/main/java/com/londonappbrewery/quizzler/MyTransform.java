package com.londonappbrewery.quizzler;

//import com.android.build.api.transform.QualifiedContent;
//import com.android.build.api.transform.Transform;
//import com.android.build.api.transform.TransformInvocation;
//import com.google.common.collect.ImmutableSet;
//
//import java.util.Set;
//
//public class MyTransform extends Transform {
//    @Override
//    public String getName() {
//        return "MyTransfrom";
//    }
//
//    @Override
//    public Set<QualifiedContent.ContentType> getInputTypes() {
//        Set types= ImmutableSet.of(QualifiedContent.DefaultContentType.CLASSES);
//        return types;
//    }
//
//    @Override
//    public Set<? super QualifiedContent.Scope> getScopes() {
//        return ImmutableSet.of(QualifiedContent.Scope.PROJECT);
////                ,QualifiedContent.Scope.SUB_PROJECTS,
////                QualifiedContent.Scope.EXTERNAL_LIBRARIES);
//    }
//
//    @Override
//    public boolean isIncremental() {
//        return false;
//    }
//
//    @Override
//    public void transform(TransformInvocation transformInvocation) {
////        Set<String> classNames = getClassNames(transformInvocation.getInputs());
////        ClassPool classPool = createClassPool(transformInvocation.getInputs(),
////                transformInvocation.getReferencedInputs());
////
////        Set<CtClass> ctClasses = getCtClasses(classPool, classNames);
//
//
////        processClasses(new ProviderGenerator(), classPool, ctClasses);
//
////        String outputPath = getOutputPath(transformInvocation.getOutputProvider());
////        saveClasses(outputPath, ctClasses);
//    }
//}
