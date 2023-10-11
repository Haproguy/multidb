package com.multidb.dbtodb;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.multidb.dbtodb.model.entity.MainTST;
import com.multidb.dbtodb.model.repository.MainTstRepo;
import com.multidb.dbtodb.subdb.entity.SubTST;
import com.multidb.dbtodb.subdb.repository.SubTstRepo;

@SpringBootApplication
public class DbtodbApplication implements CommandLineRunner {
	private MainTstRepo mainTstRepo;
	private SubTstRepo subTstRepo;

	public DbtodbApplication(MainTstRepo mainTstRepo, SubTstRepo subTstRepo) {
		this.mainTstRepo = mainTstRepo;
		this.subTstRepo = subTstRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(DbtodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<MainTST> maintsts = mainTstRepo.findAll();
		List<SubTST> subtsts = subTstRepo.findAll();
		maintsts.forEach(m -> {
			System.out.println(m.toString());
		});

		System.out.println("main clear");

		subtsts.forEach(s ->{
			System.out.println(s.toString());
		});

		System.out.println("---------------------------------------");
	}

}
