package s5;

import java.io.*;
import java.util.*;

class Person {
	int age;
	String name;
	
	public Person(int i, String s) {
		this.age=i;
		this.name=s;
	}
}

public class P10814 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Person[] people=new Person[N];
		for(int i=0;i<N;i++) {
			String input=br.readLine();
			String[] tmp=input.split(" ");
			Person person=new Person(Integer.parseInt(tmp[0]), tmp[1]);
			people[i]=person;
		}
		br.close();
		
		Arrays.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.age-p2.age;
			}		
		});
		
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		for(Person p:people) bw.append(String.valueOf(p.age)+" "+p.name+"\n");
		bw.close();
	}

}
