package c3p0Test;

import com.druid.entity.DruidNovelResource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DruidNovleDealData {
    /**
     * 查询并处理小说主表
     * @return
     */
    public static List<DruidNovelResource> dealDruidNovel () {
        String sql = "select " +
                            "id," +
                            "name," +
                            "link_txt," +
                            "has_loaddown," +
                            "repository_path," +
                            "src_has_loaddown," +
                            "src_repository_path," +
                            "link_src " +
                    "from " +
                        "druid_novel_resource " +
                        "limit 10";
        System.out.println(sql);
        List<Map<String, Object>> list = dataDeal.getC3p0list(sql);
        List<DruidNovelResource> druidNovelResourceList = new ArrayList<DruidNovelResource>();
        for (Map<String, Object> map: list) {
            druidNovelResourceList.add(
                    DruidNovelResource.builder()
                            .id((Integer) map.get("id"))
                            .name((String) map.get("name"))
                            .linkTxt((String) map.get("link_txt"))
                            .hasLoaddown((boolean)map.get("has_loaddown"))
                            .repositoryPath((String) map.get("repository_path"))
                            .srcHasLoaddown((boolean)map.get("src_has_loaddown"))
                            .srcRepositoryPath((String) map.get("src_repository_path"))
                            .linkSrc((String) map.get("link_src"))
                            .build()
            );
        }
        return druidNovelResourceList;
    }
}
