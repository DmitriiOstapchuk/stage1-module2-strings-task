package com.epam.mjc;
import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        String stringArguments = signatureString.substring(signatureString.indexOf('(')+1, signatureString.lastIndexOf(')'));
        List <MethodSignature.Argument> arguments = new ArrayList<>();
        if (stringArguments.length() > 0) {
            String[] stringArray = stringArguments.split(", ");
            for (int i = 0; i < stringArray.length; i++) {
                String[] pair = stringArray[i].split(" ");
                arguments.add(new MethodSignature.Argument(pair[0], pair[1]));
            }
        }
        String moTyNa = signatureString.substring(0, signatureString.indexOf('('));
        String[] twoOrThree = moTyNa.split(" ");
        String accessModifier;
        String returnType;
        String methodName;
        if (twoOrThree.length == 3) {
            accessModifier = twoOrThree[0];
            returnType = twoOrThree[1];
            methodName = twoOrThree[2];
        } else {
            accessModifier = null;
            returnType = twoOrThree[0];
            methodName = twoOrThree[1];
        }
        MethodSignature methodSignature = new MethodSignature(methodName, arguments);
        methodSignature.setAccessModifier(accessModifier);
        methodSignature.setReturnType(returnType);
        return methodSignature;
    }

}
