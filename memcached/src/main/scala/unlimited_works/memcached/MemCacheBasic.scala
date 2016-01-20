package unlimited_works.memcached

import java.util

import net.rubyeye.xmemcached.{CASOperation, MemcachedClient}


/**
  *
  */
class MemCacheBasic(client: MemcachedClient) {
  //get operation
  def get(key: String) = client.get(key)

  //set add replace append prepend gets
  def add = client.add("hello", 0, "dennis")
  def replace =  client.replace("hello", 0, "dennis")
  //      client.append("hello", 0, " good")
  //      client.prepend("hello", 0, "hello ")
  def response = client.gets("hello")
  def cas = response.getCas()
  def value = response.getValue()

  //incr decr
  def set = client.set("a",0,"1")
  def inrc = client.incr("a",4)
  def decr = client.decr("a",4)

  //cas
  def casWithRetry = client.cas("a", 0, new CasWithRetry(1))

  //flush_all
  def flushAll = client.flushAll()

  //stats
  def stats = client.getStats()

  // get server versions
  def getServerVersions = client.getVersions();

  //bulk get
  def keys = {
    val keys = new util.ArrayList[String]
    keys.add("hello")
    keys.add("test")
    val map = client.get(keys)
    map
  }
}

