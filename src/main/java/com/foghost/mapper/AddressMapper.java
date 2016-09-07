package com.foghost.mapper;

import com.foghost.model.Address;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AddressMapper {

	@Select("SELECT * FROM address WHERE id = #{id}")
	Address findById(@Param("id") Integer id);

	@Options(useGeneratedKeys = true)
	@Insert("insert into address ( `user_id`, `name`, `mobile`, `addr_str`, `location`, `created_at`) " +
			"VALUES (#{userId}, #{name}, #{mobile}, #{addrStr}, #{location}, #{createdAt})")
	int createAddress(Address address);
}