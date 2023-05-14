package com.mycode;

import com.google.common.collect.Sets;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Test {
  public static void main(String[] args) {
    XMLGregorianCalendar commence;
    try {
      commence = DatatypeFactory.newInstance().newXMLGregorianCalendar("2022-12-07T00:15:34.160Z");
      var date = commence.toGregorianCalendar().getTime();
      System.out.println(date);
      System.out.println(Instant.parse("2022-12-16T12:40:13.194Z").toString());
      System.out.println(Date.from(Instant.parse("2022-12-16T12:40:13.194Z")).toString());

      permutate();

      var res = porcentaje(240, 240);
      System.out.println("persentage: " + res);

      var prices = List.of(240, 50, 250);
      var pricesWithDiscount = List.of(230, 25, 20);
      var maxDiscount = getMaxDiscount(prices, pricesWithDiscount);
      System.out.println("maxDiscount: " + maxDiscount);
      var minDiscount = gerMinDiscount(prices, pricesWithDiscount);
      System.out.println("minDiscount: " + minDiscount);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void permutate() {
    String[] array = {"A", "B", "C", "D"};
    Set<String> set = Sets.newHashSet(array);
    for (int i = 1; i <= array.length; i++) {
      Set<Set<String>> combinaciones = Sets.combinations(set, i);
      for (Set<String> combinacion : combinaciones) {
        System.out.println(combinacion);
      }
    }
  }

  private static int getPrimosCountOnLinst(List<Integer> list, int index) {
    var count = 0;
    for (int i = 0; i < index; i++) {
      if (esPrimo(list.get(i))) {
        count++;
      }
    }
    return count;
  }

  private static boolean esPrimo(int n) {
    if (n <= 1) {
      return false; // los números menores o iguales a 1 no son primos
    }
    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false; // si n es divisible por algún número entre 2 y n-1, no es primo
      }
    }
    return true; // si no se encontró ningún divisor, n es primo
  }

  // function to check if a number is a "special number"
  private static boolean isSpecialNumber(int n) {
    int sum = 0;
    int temp = n;
    while (temp > 0) {
      int digit = temp % 10;
      sum += factorial(digit);
      temp /= 10;
    }
    return sum == n;
  }

  // function to calculate the factorial of digits; it can be memoized too
  private static int factorial(int n) {
    if (n == 0) return 1;

    return n * factorial(n - 1);
  }

  private static double porcentaje(double precio, double precioConDescuento) {
    return ((precio - precioConDescuento) / precio) * 100;
  }

  private static int getMaxDiscount(List<Integer> prices, List<Integer> pricesWithDiscount) {
    var maxDiscount = 0;
    for (int i = 0; i < prices.size(); i++) {
      var discount = porcentaje(prices.get(i), pricesWithDiscount.get(i));
      if (discount > maxDiscount) {
        maxDiscount = (int) discount;
      }
    }
    return maxDiscount;
  }

  private static int gerMinDiscount(List<Integer> prices, List<Integer> pricesWithDiscount) {
    var minDiscount = 100;
    for (int i = 0; i < prices.size(); i++) {
      var discount = porcentaje(prices.get(i), pricesWithDiscount.get(i));
      if (discount < minDiscount) {
        minDiscount = (int) discount;
      }
    }
    return minDiscount;
  }

  // function to check if a string is a "nice string"
  private static boolean isNiceString(String s) {
    var vowels = List.of("a", "e", "i", "o", "u");
    var forbidden = List.of("bu", "ba", "be");
    var vowelCount = 0;
    // var hasDoubleLetter = false;
    var hasForbidden = false;
    for (int i = 0; i < s.length(); i++) {
      var c = s.charAt(i);
      if (vowels.contains(c)) {
        vowelCount++;
      }
      // if (i > 0 && c == s.charAt(i - 1)) {
      //   hasDoubleLetter = true;
      // }
      if (i > 0 && forbidden.contains(s.substring(i - 1, i + 1))) {
        hasForbidden = true;
      }
    }
    // return vowelCount >= 3 && hasDoubleLetter && !hasForbidden;
    return vowelCount >= 3 && !hasForbidden;
  }
}
