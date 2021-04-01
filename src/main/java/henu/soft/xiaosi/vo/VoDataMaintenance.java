package henu.soft.xiaosi.vo;


import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VoDataMaintenance {

    private String collegeName;
    private String grassRootsTeachingSystemName;
    private List<String> arrayOfGrassRootsTeachingSystemName;
    private List<VoDataMaintenanceMajorItem> majors;
}
