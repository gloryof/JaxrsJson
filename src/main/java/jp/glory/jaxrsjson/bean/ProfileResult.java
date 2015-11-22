package jp.glory.jaxrsjson.bean;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProfileResult {

    private Summary summary;

    private List<Profile> profiles;

    public Summary getSummary() {
        return summary;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }
}
