package org.lzk.memcache;

import net.rubyeye.xmemcached.CASOperation;
import net.rubyeye.xmemcached.Counter;
import net.rubyeye.xmemcached.GetsResponse;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.transcoders.StringTranscoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.TimeoutException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemcachedTests {
    @Resource
    private MemcachedClient memcachedClient;

    @Test
    public void testGetSet() throws Exception {
        memcachedClient.set("hello", 0, "Hello,xmemcached");
        String value = memcachedClient.get("hello");
        System.out.println("hello=" + value);
        memcachedClient.delete("hello");
    }


    @Test
    public void testMore() throws Exception {
        if (!memcachedClient.set("hello", 0, "world")) {
            System.err.println("set error");
        }
        if (!memcachedClient.add("hello", 0, "dennis")) {
            System.err.println("Add error,key is existed");
        }
        if (!memcachedClient.replace("hello", 0, "dennis")) {
            System.err.println("replace error");
        }
        String name1 = memcachedClient.get("hello", new StringTranscoder());
        System.out.println(name1);
        memcachedClient.append("hello", " good");
        memcachedClient.prepend("hello", "hello ");
        String name = memcachedClient.get("hello", new StringTranscoder());
        System.out.println(name);
        memcachedClient.deleteWithNoReply("hello");
    }
    @Test
    public void testIncrDecr() throws Exception {
        memcachedClient.delete("Incr");
        memcachedClient.delete("Decr");
        System.out.println(memcachedClient.incr("Incr", 6, 12));
        System.out.println(memcachedClient.incr("Incr", 3));
        System.out.println(memcachedClient.incr("Incr", 2));
        System.out.println(memcachedClient.decr("Decr", 1, 6));
        System.out.println(memcachedClient.decr("Decr", 2));
    }

    @Test
    public void testCounter() throws Exception {
//        MemcachedClient memcachedClient = memcachedUtil.getMemcachedClient();
        Counter counter=memcachedClient.getCounter("counter",10);
        System.out.println("counter="+counter.get());
        long c1 =counter.incrementAndGet();
        System.out.println("counter="+c1);
        long c2 =counter.decrementAndGet();
        System.out.println("counter="+c2);
        long c3 =counter.addAndGet(-10);
        System.out.println("counter="+c3);
    }
    @Test
    public void testCase() throws InterruptedException, MemcachedException, TimeoutException {
        memcachedClient.set("a",0,10);
        GetsResponse<Integer> result = memcachedClient.gets("a");
        long cas = result.getCas();
//尝试将 a 的值更新为 2
        if (!memcachedClient.cas("a", 0, 2, cas)) {
            System.err.println("cas error");
        }


        /**
         * simplief code
         */
        memcachedClient.cas("a", 0, new CASOperation<Integer>() {
            public int getMaxTries() {
                return 1;
            }

            public Integer getNewValue(long currentCAS, Integer currentValue) {
                return 2;
            }
        });

    }


    @Test
    public void testTouch() throws Exception {
        memcachedClient.set("Touch", 2, "Touch Value");
        Thread.sleep(1000);
        memcachedClient.touch("Touch",6);
        Thread.sleep(2000);
        String value =memcachedClient.get("Touch",3000);
        System.out.println("Touch=" + value);
    }

    @Test
    public void testStatus() throws InterruptedException, MemcachedException, TimeoutException {
        Map<InetSocketAddress, Map<String,String>> result=memcachedClient.getStats();
        System.out.println(result);
    }
}

