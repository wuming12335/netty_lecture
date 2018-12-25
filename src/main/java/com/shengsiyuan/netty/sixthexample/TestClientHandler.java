package com.shengsiyuan.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
      int random = new Random().nextInt(3);
        MyDataInfo.MyMessage myMessage = null;
      if(0 == random){
          myMessage = MyDataInfo.MyMessage.newBuilder()
          .setDataType(MyDataInfo.MyMessage.DataType.PersonType)
          .setPerson(MyDataInfo.Person.newBuilder()
          .setName("张三").setAge(20).setAddress("北京").build()).build();

      }else if(1 == random){
        myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.DogType)
            .setDog(MyDataInfo.Dog.newBuilder()
            .setName("旺旺").setAge(10).build()).build();
      }else{
        myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo
            .MyMessage.DataType.CatType).setCat(MyDataInfo.Cat.newBuilder()
            .setCity("北京").setName("虹猫").build()).build();
      }

      ctx.channel().writeAndFlush(myMessage);

    }
}
