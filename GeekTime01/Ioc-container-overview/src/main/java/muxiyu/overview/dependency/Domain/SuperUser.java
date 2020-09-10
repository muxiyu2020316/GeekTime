package muxiyu.overview.dependency.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import muxiyu.overview.dependency.annotation.Super;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Super
/**
 * 超级用户
 */
public class SuperUser extends User{
    String  address;
}
