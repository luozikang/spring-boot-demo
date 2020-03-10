```
Memcached 集群
Memcached 的分布是通过客户端实现的，客户端根据 key 的哈希值得到将要存储的 Memcached 节点，并将对应的 value 存储到相应的节点。

XMemcached 同样支持客户端的分布策略，默认分布的策略是按照 key 的哈希值模以连接数得到的余数，对应的连接就是将要存储的节点。如果使用默认的分布策略，不需要做任何配置或者编程。

XMemcached 同样支持一致性哈希（Consistent Hash)，通过编程设置：

MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("server1:11211 server2:11211 server3:11211"));
builder.setSessionLocator(new KetamaMemcachedSessionLocator());
MemcachedClient client=builder.build();
XMemcached 还提供了额外的一种哈希算法——选举散列，在某些场景下可以替代一致性哈希：

MemcachedClientBuilder builder = new XMemcachedClientBuilder(
                                    AddrUtil.getAddresses("server1:11211 server2:11211 server3:11211"));
builder.setSessionLocator(new ElectionMemcachedSessionLocator());
MemcachedClient mc = builder.build();
在集群的状态下可以给每个服务设置不同的权重：

MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("localhost:12000 localhost:12001"),new int[]{1,3});
MemcachedClient memcachedClient=builder.build();
SASL 验证

Memcached 1.4.3 开始支持 SASL 验证客户端，在服务器配置启用 SASL 之后，客户端需要通过授权验证才可以跟 Memcached 继续交互，否则将被拒绝请求，XMemcached 1.2.5 开始支持这个特性。假设 Memcached 设置了 SASL 验证，典型地使用 CRAM-MD 5 或者 PLAIN 的文本用户名和密码的验证机制，假设用户名为 cacheuser，密码为 123456，那么编程的方式如下：

MemcachedClientBuilder builder = new XMemcachedClientBuilder(
                AddrUtil.getAddresses("localhost:11211"));
builder.addAuthInfo(AddrUtil.getOneAddress("localhost:11211"), AuthInfo
                .typical("cacheuser", "123456"));
// Must use binary protocol
builder.setCommandFactory(new BinaryCommandFactory());
MemcachedClient client=builder.build();
请注意，授权验证仅支持二进制协议。

查看统计信息
Memcached 提供了统计协议用于查看统计信息：

Map<InetSocketAddress,Map<String,String>> result=client.getStats();
getStats 方法返回一个 map ，其中存储了所有已经连接并且有效的 Memcached 节点返回的统计信息，你也可以统计具体的项目，如统计 items 项目：

Map<InetSocketAddress,Map<String,String>> result=client.getStatsByItem("items");
只要向 getStatsByItem 传入需要统计的项目名称即可，我们可以利用这个功能，来做 Memcached 状态监控等。
```