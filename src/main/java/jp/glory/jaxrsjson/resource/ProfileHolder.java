package jp.glory.jaxrsjson.resource;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import jp.glory.jaxrsjson.bean.Profile;
import jp.glory.jaxrsjson.bean.ProfileResult;
import jp.glory.jaxrsjson.bean.Summary;
import jp.glory.jaxrsjson.bean.Type;

@Path("profile")
public class ProfileHolder {

    // JAX-RSのみで動かすのでCDIを使わず直接インスタンス生成
    private static final List<Profile> profiles = new ArrayList<>();

    static {

        profiles.add(Profile.build("山田", "太郎", Type.YOUTH, 25));
        profiles.add(Profile.build("佐藤", "花子", Type.VETERAN, 48));
        profiles.add(Profile.build("鈴木", "一郎", Type.VETERAN, 42));
    }

    @POST
    @Path("add")
    @Consumes("application/json")
    public Response save(Profile profile) {

        System.out.println("==================== Profile Save  ====================");
        System.out.println("Name : " + profile.getName().getLast() + " " + profile.getName().getFirst());
        System.out.println("Type : " + profile.getType().name());
        System.out.println("Age : " + profile.getAge());

        profiles.add(profile);

        return Response.ok().build();
    }

    @GET
    @Path("get")
    @Produces("application/json")
    public ProfileResult list() {

        ProfileResult result = new ProfileResult();
        result.setSummary(Summary.build(profiles));
        result.setProfiles(profiles);

        return result;
    }

}
