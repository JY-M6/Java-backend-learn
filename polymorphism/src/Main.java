public class Main {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("jack",22,"as");
        people[1] = new Person("john",19,"as");
        people[2] = new Person("jane",20,"as");
        for(int i = 0; i < people.length; i++){
            System.out.println(people[i]);
        }
        Person temp;
        for (int i = 0; i < people.length-1; i++) {
            for (int j = 0; j < people.length-1-i; j++) {
                if (people[j].getAge() < people[j+1].getAge()) {
                    temp = people[j];
                    people[j] = people[j+1];
                    people[j+1] = temp;
                }
            }
        }

        for(int i = 0; i < people.length; i++){
            System.out.println(people[i]);
        }




    }
}
