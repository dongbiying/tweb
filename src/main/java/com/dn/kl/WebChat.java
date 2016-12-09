package com.dn.kl;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class WebChat extends JedisPubSub{

	@Override
	public void onMessage(String channel, String message) {
		// TODO Auto-generated method stub
	//	super.onMessage(channel, message);
		System.out.println(channel+":"+message);
	}

	@Override
	public void onSubscribe(String channel, int subscribedChannels) {
		// TODO Auto-generated method stub
		super.onSubscribe(channel, subscribedChannels);
		System.out.println(channel+":"+subscribedChannels);
	}
	
	public static void main(String[] args) {
		Jedis jedis = null;
		try{
			WebChat webChat = new WebChat();
			jedis = new Jedis("192.168.66.10",1000,0);
			webChat.proceed(jedis.getClient(), "dn");
		}catch(Exception e){
			
		}finally {
			if(jedis!=null)
				jedis.close();
		}	

	}
	
}
