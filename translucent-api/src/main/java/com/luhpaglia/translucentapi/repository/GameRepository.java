package com.luhpaglia.translucentapi.repository;

import com.luhpaglia.translucentapi.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Set;

public interface GameRepository extends JpaRepository<Game, Integer>{

}
