package jp.glory.jaxrsjson.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Summary {

    private int totalCount;
    private int youthCounts;
    private int veteranCounts;

    public static Summary build(List<Profile> profiles) {

        Summary summary = new Summary();
        summary.setTotalCount(profiles.size());
        Map<Type, List<Profile>> result = profiles.stream()
                .collect(Collectors.groupingBy(Profile::getType));

        final List<Profile> emptyList = new ArrayList<>();
        summary.setYouthCounts(result.getOrDefault(Type.YOUTH, emptyList).size());
        summary.setVeteranCounts(result.getOrDefault(Type.VETERAN, emptyList).size());

        return summary;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getYouthCounts() {
        return youthCounts;
    }

    public void setYouthCounts(int youthCounts) {
        this.youthCounts = youthCounts;
    }

    public int getVeteranCounts() {
        return veteranCounts;
    }

    public void setVeteranCounts(int veteranCounts) {
        this.veteranCounts = veteranCounts;
    }

}
