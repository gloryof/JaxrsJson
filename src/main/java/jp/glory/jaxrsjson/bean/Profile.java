package jp.glory.jaxrsjson.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {

    private Name name;
    private Type type;
    private Integer age;

    public static Profile build(String lastName, String firstName, Type type, int age) {

        Profile profile = new Profile();

        Name name = new Name();
        name.setLast(lastName);
        name.setFirst(firstName);

        profile.name = name;
        profile.type = type;
        profile.age = age;

        return profile;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
