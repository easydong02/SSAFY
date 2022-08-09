package com.ssafy.corona.virus;

import java.util.Arrays;

public class VirusMgrImpl implements VirusMgr {
	
	private Virus[] virus;
	private int index;
	
	//싱글톤
	public static VirusMgr manager=new VirusMgrImpl();
	private VirusMgrImpl() {
		virus=new Virus[100];		
	}
	public static VirusMgr getInstance() {
		return manager;
	}
	//
	
	@Override
	public void add(Virus v) throws DuplicatedException{
		try {
			search(v.getName());
			throw new DuplicatedException("등록된 바이러스입니다. ");
		}catch (NotFoundException e) {
			virus[index++]=v;
		}
	}
	@Override
	public Virus[] search() {
		//return virus;
		return Arrays.copyOf(virus, index);
	}
	@Override
	public Virus search(String name) throws NotFoundException{
		// virus.length -> index
		for(int i=0; i<index; i++) {
			if(virus[i].getName().equals(name)) return virus[i];
		}
		throw new NotFoundException(name+": 미등록 바이러스입니다.");
	}//  
	@Override
	public void save() {
		
	}
	@Override
	public void sortByName() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sortByLevel() {
		// TODO Auto-generated method stub
		
	}
}
