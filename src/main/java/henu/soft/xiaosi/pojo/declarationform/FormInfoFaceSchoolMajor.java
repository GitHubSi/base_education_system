package henu.soft.xiaosi.pojo.declarationform;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class FormInfoFaceSchoolMajor {

    // 面向校内专业名称
    private String schoolOrientedProfessionalTitles;
    // 代码
    private String schoolOrientedProfessionalTitlesCode;
    // 比例
    private String schoolOrientedProfessionalTitlesProporation;
}
