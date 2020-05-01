package com.strength.studio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.strength.studio.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, BaseRepository<Member, Long>{

}
