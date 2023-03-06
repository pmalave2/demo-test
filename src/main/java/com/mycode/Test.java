package com.mycode;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
      Map<String, String> external = Map.of();
      System.out.println(Objects.isNull(external) || external.isEmpty());

      String[] strings = {"a", "a"};
      helper(strings, 0);
      var l = Arrays.asList("a", "b", "c");
      System.out.println(permutate(l));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void helper(String[] array, int pos) {
    if (pos >= array.length - 1) {
      System.out.print("[");
      for (int i = 0; i < array.length - 1; i++) {
        System.out.print(array[i] + ", ");
      }
      if (array.length > 0) System.out.print(array[array.length - 1]);
      System.out.println("]");
      return;
    }

    for (int i = pos; i < array.length; i++) {

      String t = array[pos];
      array[pos] = array[i];
      array[i] = t;

      helper(array, pos + 1);

      t = array[pos];
      array[pos] = array[i];
      array[i] = t;
    }
  }

  public static <T> List<List<T>> permutate(List<T> src) {
    if (src.size() <= 1) {
      List<List<T>> al = new ArrayList<>();
      al.add(src);
      return al;
    }

    List<List<T>> result = new ArrayList<>();
    for (int i = 0; i < src.size(); i++) {
      List<T> copy = new ArrayList<>(src);
      T el = copy.remove(i);

      for (List<T> perm : permutate(copy)) {
        List<T> c = new ArrayList<>(perm);
        c.add(0, el);
        result.add(c);
      }
    }

    return result;
  }
}
