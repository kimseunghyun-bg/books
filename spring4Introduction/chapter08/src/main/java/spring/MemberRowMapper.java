package spring;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Seunghyun Kim
 * @since 2020-04-01
 */
final class MemberRowMapper implements RowMapper {
    @Override
    public Member mapRow(ResultSet rs, int i) throws SQLException {
        Member member = new Member(rs.getString("EMAIL"),
                rs.getString("PASSWORD"),
                rs.getString("NAME"),
                rs.getTimestamp("REGDATE"));
        member.setId(rs.getLong("ID"));
        return member;
    }
}
