package lab0;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class Variant12Test {
    private static final double PI = 3.14;

    @Test(dataProvider = "inputOutputProvider")
    public void testInputOutputTask(double a, double b, double expectedHypotenuse, double expectedPerimeter) {
        assertEquals(new Variant12().inputOutputTask(a, b), new double[] {expectedHypotenuse, expectedPerimeter});
    }

    @DataProvider(name = "inputOutputProvider")
    public Object[][] triangleData() {
        return new Object[][] {
                {3.0, 4.0, 5.0, 12.0},
                {5.0, 12.0, 13.0, 30.0},
                {6.0, 8.0, 10.0, 24.0}
        };
    }

    @Test(dataProvider = "integerProvider")
    public void testIntegerTask(int input, int expected) {
        assertEquals(new Variant12().integerNumbersTask(input), expected);
    }

    @DataProvider(name = "integerProvider")
    public Object[][] testData() {
        return new Object[][] {
                {123, 321},
                {456, 654},
                {789, 987}
        };
    }


    @Test(dataProvider = "testBooleanTask1")
    public void testBooleanTask1(int a, int b, int c) {
        assertTrue(new Variant12().booleanTask(a, b, c));
    }

    @DataProvider(name = "testBooleanTask1")
    public Object[][] TestBooleanNumbers1() {
        return new Object[][] {
                { 1, 2, 3 },
                { 9, 22324, 3 }
        };
    }
    @Test(dataProvider = "testBooleanTask2")
    public void testBooleanTask2(int a, int b, int c) {
        assertFalse(new Variant12().booleanTask(a, b, c));
    }
    @DataProvider(name = "testBooleanTask2")
    public Object[][] TestBooleanNumbers2() {
        return new Object[][] {
                { -1, 2, 3 },
                { 0, -22324, 3 },
                {112, 328, -2}
        };
    }


    @Test(dataProvider = "testIfTask")
    public void testIfTask(int a, int b, int c) {
        assertEquals(new Variant12().ifTask(a, b, c), Math.min(Math.min(a, b), c));
    }

    @DataProvider(name = "testIfTask")
    public Object[][] testIf() {
        return new Object[][] {
                { 1, 2, 3 },
                { 5, 3, 7 },
                { -1, -2, -3 },
                { 0, 0, 0 }
        };
    }


    @Test(dataProvider = "switchProvider")
    public void testSwitchTask(int elementNumber, double elementValue) {
        double[] result = new Variant12().switchTask(elementNumber, elementValue);

        switch (elementNumber) {
            case 1 ->
                    assertEquals(result, new double[]{elementValue, 2.0 * elementValue, 2.0 * PI * elementValue, PI * elementValue * elementValue});
            case 2 ->
                    assertEquals(result, new double[]{elementValue / 2.0, elementValue, PI * elementValue, PI * (elementValue / 2.0) * (elementValue / 2.0)});
            case 3 ->
                    assertEquals(result, new double[]{elementValue / (2.0 * PI), elementValue / PI, elementValue, (elementValue / (2.0 * PI)) * (elementValue / (2.0 * PI)) * PI});
            case 4 -> {
                double radius = Math.sqrt(elementValue / PI);
                assertEquals(result, new double[]{radius, 2.0 * radius, 2.0 * PI * radius, elementValue});
            }
            default -> fail("Enter correct number. ");
        }
    }

    @DataProvider(name = "switchProvider")
    public Object[][] switchTest() {
        return new Object[][] {
                { 1, 5.0 },
                { 2, 10.0 },
                { 3, 31.4 },
                { 4, 78.5 }
        };
    }

    @Test(dataProvider = "forProvider")
    public void testForProvider(int n, double expectedProduct) {
        assertEquals(new Variant12().forTask(n), expectedProduct, 0.0001);
    }

    @DataProvider(name = "forProvider")
    public Object[][] inputData() {
        return new Object[][] {
                { 1, 1.1 },
                { 5, 1.1 * 1.2 * 1.3 * 1.4 * 1.5 },
                { 10, 1.1 * 1.2 * 1.3 * 1.4 * 1.5 * 1.6 * 1.7 * 1.8 * 1.9 * 2.0 }
        };
    }


    @Test(dataProvider = "whileProvider")
    public void testWhileTask(int n, int expectedK, int expectedSum) {
        assertEquals(new Variant12().whileTask(n), new int[] {expectedK, expectedSum});
    }

    @DataProvider(name = "whileProvider")
    public Object[][] testWhileTask() {
        return new Object[][] {
                { 5, 2, 3 },
                { 10, 4, 10 },
                { 15, 5, 15 }
        };
    }

    @Test(dataProvider = "arrayProvider")
    public void testArrayTask(int[] array, int[] expectedOutput) {
        assertEquals(new Variant12().arrayTask(array), expectedOutput);
    }

    @DataProvider(name = "arrayProvider")
    public Object[][] arrayProvider() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4, 5, 6}, new int[]{2, 4, 6}},
                {new int[]{10, 20, 30, 40}, new int[]{20, 40}}
        };
    }


    @Test(dataProvider = "matrixProvider")
    public void testNewMatrix(double[][] matrix, double[] expectedOutput) {
        assertEquals(new Variant12().newMatrix(matrix), expectedOutput);
    }

    @DataProvider(name = "matrixProvider")
    public Object[][] matrixData() {
        return new Object[][] {
                {
                        new double[][] {
                                { 1, 2, 3 },
                                { 4, 5, 6 },
                                { 7, 8, 9 }
                        },
                        new double[] { 1, 4, 7, 8, 5, 2, 3, 6, 9 }
                },
                {
                        new double[][] {
                                { 11, 12, 13, 14 },
                                { 21, 22, 23, 24 },
                                { 31, 32, 33, 34 }
                        },
                        new double[] { 11, 21, 31, 32, 22, 12, 13, 23, 33, 34, 24, 14 }
                }
        };
    }
}

