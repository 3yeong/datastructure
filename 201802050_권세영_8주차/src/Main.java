import java.util.*;

public class Main {
    public static void main(String[] args) {
        OpenAddressing op = new OpenAddressing(20, 10);
        CloseAddressing closeAddressing = new CloseAddressing(20, 10);

        System.out.println("\n-------------- * CloseAddressing * --------------");
        System.out.println("close 실행");
        long closestart = System.currentTimeMillis();
        // Insert entries
        closeAddressing.put(10, "가연");
        closeAddressing.put(12, "세영");
        closeAddressing.put(85, "민수");
        closeAddressing.put(23, "민희");
        closeAddressing.put(24, "지혜");
        closeAddressing.put(27, "수경");
        closeAddressing.put(66, "주하");
        closeAddressing.put(93, "지연");
        closeAddressing.put(100, "정준");

        int size = closeAddressing.size();
        System.out.println("Hash size : " + size);

        Set keys = closeAddressing.keySet();
        System.out.println("KeySet : " + keys);

        Collection values = closeAddressing.values();
        System.out.println("Values : " + values);

        Set entries = closeAddressing.entrySet();
        System.out.println("EntruSet" + entries);

        boolean hasGayeon = closeAddressing.containsValue("가연");
        System.out.println("hasGayeon : " + hasGayeon);

        boolean has100Key = closeAddressing.containsKey(100);
        System.out.println("has100Key : " + has100Key);

        // Create new map whose size is 10 and put them all to closeAddressing hashmap.
        System.out.println("\n--------------Put new map--------------");
        Map<Object, Object> newMap = new HashMap<>();
        for (int i = 200; i < 2200; i++) {
            newMap.put(i, "추가" + i);
        }

        closeAddressing.putAll(newMap); // After executing this function, the size of closeAddressing would be 19 ( original(9) + new(10)).

        size = closeAddressing.size();
        System.out.println("Hash size : " + size);

        Set newKeys = closeAddressing.keySet();
        System.out.println("KeySet : " + newKeys);

        Collection newValues = closeAddressing.values();
        System.out.println("Values : " + newValues);

        Set newEntries = closeAddressing.entrySet();
        System.out.println("EntruSet" + newEntries);
        long closeend = System.currentTimeMillis();
        System.out.println("close 끝");
        System.out.print(closeend - closestart);

        System.out.println("\n-------------- * OpenAddressing * --------------");
        System.out.println("\nopen 실행");
        long openstart = System.currentTimeMillis();
        //open addressing
        op.put(10, "가연");
        op.put(12, "세영");
        op.put(85, "민수");
        op.put(23, "민희");
        op.put(24, "지혜");
        op.put(27, "수경");
        op.put(66, "주하");
        op.put(93, "지연");
        op.put(100, "정준");

        int sizeop = op.size();
        System.out.println("Hash size : " + sizeop);

        Set keysop = op.keySet();
        System.out.println("KeySet : " + keysop);

        Collection valuesop = op.values();
        System.out.println("Values : " + valuesop);

        Set entriesop = op.entrySet();
        System.out.println("EntruSet" + entriesop);

        boolean hasGayeonop = op.containsValue("가연");
        System.out.println("hasGayeon : " + hasGayeonop);

        boolean has100Keyop = op.containsKey(100);
        System.out.println("has100Key : " + has100Keyop);

        // Create new map whose size is 10 and put them all to closeAddressing hashmap.
        System.out.println("\n--------------Put new map--------------");
        Map<Object, Object> newMapop = new HashMap<>();
        for (int i = 200; i < 2200; i++) {
            newMapop.put(i, "추가" + i);
        }
        op.putAll(newMapop); // After executing this function, the size of closeAddressing would be 19 ( original(9) + new(10)).

        sizeop = op.size();
        System.out.println("Hash size : " + sizeop);

        Set newKeysop = op.keySet();
        System.out.println("KeySet : " + newKeysop);

        Collection newValuesop = op.values();
        System.out.println("Values : " + newValuesop);

        Set newEntriesop = op.entrySet();
        System.out.println("EntruSet" + newEntriesop);
        long openend = System.currentTimeMillis();
        System.out.println("open 끝");
        System.out.println(openend - openstart);
    }
}
