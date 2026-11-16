//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    List<String> payers = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "B"));
    List<Long> amounts = new ArrayList<>(Arrays.asList(1000L, 3000L, 0L, 2000L, 5000L, 4300L));
    Map<String, Long> totalPaid = new HashMap<>();

    for(int i = 0; i < payers.size(); i++){
        String currkey = payers.get(i);
        Long currval = amounts.get(i);
        if(totalPaid.containsKey(currkey)){
            currval += totalPaid.get(currkey);
            totalPaid.put(currkey, currval);
        }
        else{
            totalPaid.put(currkey, currval);
        }
    }

    totalPaid.forEach((key, value) -> System.out.println(key + " -> " + value));

    Set<String> people = new HashSet<>(payers);
    System.out.println(people);
}
