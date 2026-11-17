//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    enum Category {FOOD, TRAVEL, RENT, OTHER};
    record Expense(String payer, Long amount, String description, Category category){}
    List<Expense> expenses = new ArrayList<>();
    expenses.add(new Expense("A", 1000L, "d1", Category.FOOD));
    expenses.add(new Expense("B", 3000L, "d2", Category.TRAVEL));
    expenses.add(new Expense("C", 0L, "d3", Category.RENT));
    expenses.add(new Expense("D", 2000L, "d4", Category.OTHER));
    expenses.add(new Expense("E", 5000L, "d5", Category.FOOD));
    expenses.add(new Expense("B", 4300L, "d6", Category.OTHER));
    expenses.add(new Expense("B", 4300L, "d6", Category.OTHER));

    Map<String, Long> totalPaid = new HashMap<>();
    Set<String> people = new HashSet<>();

    for (Expense expense : expenses) {
        totalPaid.merge(expense.payer(), expense.amount(), Long::sum);
        people.add(expense.payer());
    }
    System.out.println(expenses.get(0));
    totalPaid.forEach((key, value) -> System.out.println(key + " -> " + value));

    System.out.println(people);

    System.out.println(expenses.get(5).equals(expenses.get(6)));
}
