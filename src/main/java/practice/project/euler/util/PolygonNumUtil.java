package practice.project.euler.util;

/*
Triangle 	  	P3,n=n(n+1)/2 	  	1, 3, 6, 10, 15, ...
Square 	  	P4,n=n2 	  	1, 4, 9, 16, 25, ...
Pentagonal 	  	P5,n=n(3n−1)/2 	  	1, 5, 12, 22, 35, ...
Hexagonal 	  	P6,n=n(2n−1) 	  	1, 6, 15, 28, 45, ...
Heptagonal 	  	P7,n=n(5n−3)/2 	  	1, 7, 18, 34, 55, ...
Octagonal 	  	P8,n=n(3n−2) 	  	1, 8, 21, 40, 65, ...
 */
public class PolygonNumUtil {

    public static boolean isPolyagonalNumber(int p, long number) {
        double tmp = getPolyagonalN(p,number);
        return (long)tmp == tmp;
    }

    public static double getPolyagonalN(int p, long number) {
        return (Math.sqrt( (p-4) * (p-4) + (number * (8*p - 16 ))) + p - 4) / (2 * p - 4);
    }

//    public static boolean isTriangleNumber(long num) {
//        double tmp = (Math.sqrt(1 + 8 * num) - 1) / 2;
//        return (int)tmp == tmp;
//    }
//
//    public static boolean isPentagonalNumber(long num) {
//        double tmp = (1 + Math.sqrt(1 + 24 * num)) / 6;
//        return (int)tmp == tmp;
//    }
//
//    public static boolean isHexagonalNumber(long num) {
//        double tmp = (Math.sqrt(1 + 8 * num) + 1) / 4;
//        return (int)tmp == tmp;
//    }
//
//    public static boolean isHeptagonalNumber(long num) {
//        double tmp = (1 + Math.sqrt(1 + 24 * num)) / 6;
//        return (int)tmp == tmp;
//    }
//
//    public static boolean isOctagonalNumber(long num) {
//        double tmp = (Math.sqrt(1 + 8 * num) - 1) / 2;
//        return (int)tmp == tmp;
//    }

}
