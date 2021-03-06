package com.tammy.ourpage.model;

public class User {
    public User(){
        this.uname="";
        this.password="";
        this.uright=Right.ALL.getValue();
        this.avatar="";
        this.email="";
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.iduser
     *
     * @mbggenerated Sat May 07 14:32:37 JST 2016
     */
    private Integer iduser;

    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.uname
     *
     * @mbggenerated Sat May 07 14:32:37 JST 2016
     */
    private String uname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbggenerated Sat May 07 14:32:37 JST 2016
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.uright
     *
     * @mbggenerated Sat May 07 14:32:37 JST 2016
     */
    private Integer uright;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.avatar
     *
     * @mbggenerated Sat May 07 14:32:37 JST 2016
     */
    private String avatar;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.iduser
     *
     * @return the value of user.iduser
     *
     * @mbggenerated Sat May 07 14:32:37 JST 2016
     */
    public Integer getIduser() {
        return iduser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.iduser
     *
     * @param iduser the value for user.iduser
     *
     * @mbggenerated Sat May 07 14:32:37 JST 2016
     */
    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.uname
     *
     * @return the value of user.uname
     *
     * @mbggenerated Sat May 07 14:32:37 JST 2016
     */
    public String getUname() {
        return uname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.uname
     *
     * @param uname the value for user.uname
     *
     * @mbggenerated Sat May 07 14:32:37 JST 2016
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbggenerated Sat May 07 14:32:37 JST 2016
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbggenerated Sat May 07 14:32:37 JST 2016
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.uright
     *
     * @return the value of user.uright
     *
     * @mbggenerated Sat May 07 14:32:37 JST 2016
     */
    public Integer getUright() {
        return uright;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.uright
     *
     * @param uright the value for user.uright
     *
     * @mbggenerated Sat May 07 14:32:37 JST 2016
     */
    public void setUright(Integer uright) {
        this.uright = uright;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.avatar
     *
     * @return the value of user.avatar
     *
     * @mbggenerated Sat May 07 14:32:37 JST 2016
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.avatar
     *
     * @param avatar the value for user.avatar
     *
     * @mbggenerated Sat May 07 14:32:37 JST 2016
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


}