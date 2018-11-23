package org.lig.org.lig.jdkcollection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * jdk中的LinkedHashMap的case
 *
 */
public class CaseLinkedHashMap {

    public boolean isTest(String caseStr) {
        return caseStr == null;
    }

    public static void main(String[] args) {
        LRUCache t = new LRUCache();
        System.out.println( t.map.isTest( null ) );
        System.out.println(1 << 30);
        System.out.println(Integer.MAX_VALUE);
    }

}

class LRUCache<K, V> {

    LinkedHashMap<K, V> cache = new LinkedHashMap<K, V>( 16, 0.75f, true ){
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size()>3;
        }
    };
    CaseLinkedHashMap map = new CaseLinkedHashMap() {
        @Override
        public boolean isTest(String caseStr) {
            return super.isTest( caseStr );
        }
    };




}
