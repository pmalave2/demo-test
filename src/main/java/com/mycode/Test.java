package com.mycode;

import com.google.common.collect.Sets;
import java.time.Instant;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Objects;
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
      var external = new LinkedHashMap<String, String>();
      System.out.println(Objects.isNull(external) || external.isEmpty());

      permutate2();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void permutate2() {
    String[] array = {"A", "B", "C", "D"};
    Set<String> set = Sets.newHashSet(array);
    for (int i = 1; i <= array.length; i++) {
      Set<Set<String>> combinaciones = Sets.combinations(set, i);
      for (Set<String> combinacion : combinaciones) {
        System.out.println(combinacion);
      }
    }
  }
}
