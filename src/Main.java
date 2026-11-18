public static <T> T lastOf(List<T> items){
    int len = items.size();
    return items.get(len - 1);
}
void main() {
    enum Category {FOOD, TRAVEL, RENT, OTHER};
    record Expense(String payer, Long amount, String description, Category category){
        public Expense{
            if(amount <= 0){
                throw new InvalidExpenseException("Amount less than 0");
            }
            if(payer.isEmpty()){
                throw new InvalidExpenseException("Payer is empty");
            }
        }
    }
    List<Expense> expenses = new ArrayList<>();
    try{
        expenses.add(new Expense("A", 1000L, "d1", Category.FOOD));
        expenses.add(new Expense("B", 3000L, "d2", Category.TRAVEL));
//        expenses.add(new Expense("C", 0L, "d3", Category.RENT));
        expenses.add(new Expense("C", 100L, "d3", Category.RENT));
        expenses.add(new Expense("D", 2000L, "d4", Category.OTHER));
        expenses.add(new Expense("E", 5000L, "d5", Category.FOOD));
        expenses.add(new Expense("B", 4300L, "d6", Category.OTHER));
        expenses.add(new Expense("B", 4300L, "d6", Category.OTHER));
    }
    catch(InvalidExpenseException iee){
        System.out.println(iee.getMessage());
    }

    Map<String, Long> totalPaid = new HashMap<>();
    Set<String> people = new HashSet<>();

    for (Expense expense : expenses) {
        totalPaid.merge(expense.payer(), expense.amount(), Long::sum);
        people.add(expense.payer());
    }
    System.out.println(expenses.get(0));
    totalPaid.forEach((key, value) -> System.out.println(key + " -> " + value));

    System.out.println(people);
    System.out.println(expenses);
    System.out.println(lastOf(expenses));
//    System.out.println(expenses.get(5).equals(expenses.get(6)));
}
