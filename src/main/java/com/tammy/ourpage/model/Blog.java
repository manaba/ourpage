package com.tammy.ourpage.model;

/**
 * Created by tammy on 16/4/11.
 */
public class Blog {
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title=title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content){
        this.content=content;
    }
    public  int getTypeID(){return typeID;}
    public  void  setTypeID(int typeID){this.typeID=typeID;}
    public  int getThumbCount(){return thumbCount;}
    public  void setThumbCount(int thumbCount){
        this.thumbCount=thumbCount;
    }
    public int getReadCount(){return readCount;}
    public void  setReadCount(int readCount){
        this.readCount=readCount;
    }
    public int getPrefID(){return  prefID;}
    public void setPrefID(int prefID){
        this.prefID=prefID;
    }
    public  int getNextID(){return  nextID;}
    public  void  setNextID(int nextID){
        this.nextID=nextID;
    }
    public long getTime(){return time;}
    public void setTime(long time){
        this.time=time;
    }
    public boolean getIsTop(){return isTop;}
    public void setIsTop(boolean isTop){
        this.isTop=isTop;
    }
    public int getPrivacy(){return privacy;}
    public void setPrivacy(int privacy){
        this.privacy=privacy;
    }

    public Blog(){
        this.title="none";
        this.content="none";
        this.typeID=0;
        this.thumbCount=0;
        this.readCount=0;
        this.prefID=0;
        this.nextID=0;
        this.time=System.currentTimeMillis();
        this.isTop=false;
        this.privacy=0;
    }

    private String title;
    private String content;
    private int typeID;
    private int thumbCount;
    private int readCount;
    private int prefID;
    private int nextID;
    private long time;
    private boolean isTop;
    private int privacy;
}
