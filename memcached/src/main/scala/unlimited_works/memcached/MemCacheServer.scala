package unlimited_works.memcached

import net.rubyeye.xmemcached.{MemcachedClient, XMemcachedClientBuilder}
import net.rubyeye.xmemcached.command.{KestrelCommandFactory, BinaryCommandFactory}
import net.rubyeye.xmemcached.utils.AddrUtil

object MemCacheServer {
  //New a XMemcachedClient instance
  def normal = {
    val builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("localhost:11211"))
    builder.build()
  }

  //If you want to use binary protocol
  def binary = {
    val builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("localhost:11211"))

    builder.setCommandFactory(new BinaryCommandFactory())
    builder.build()
  }

  def kestrel = {
    val builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("localhost:11211"))
    builder.setCommandFactory(new KestrelCommandFactory())
    builder.build()
  }

  //If you want to store primitive type as String
  def stringStore(client: MemcachedClient) = {
    client.setPrimitiveAsString(true)
  }

  //Add or remove memcached server dynamically
  def add(client: MemcachedClient) = {
    client.addServer("localhost:12001 localhost:12002")
  }

  def remove(client: MemcachedClient) = {
    client.removeServer("localhost:12001 localhost:12002")
  }
}
