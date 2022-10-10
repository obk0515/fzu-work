package com.fzu.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@SuppressWarnings("AlibabaAvoidCommentBehindStatement")
@Data
public class Rand {

	//固定缺勤的学生id
	public List<Integer> absent_stu_id=new ArrayList<>();
	//固定缺勤的学生数
	public int fixed_absent_num;

	//获取一门课固定会缺勤的学生数量（生成5-8中的一个数字）
	public int get_fixed_absent_num() {
		Random random = new Random();
		int fixed_absent_num=5 + random.nextInt( 4);
		return fixed_absent_num;
	}

	public static int random(List<Integer> weight){
		List<Integer> weightTmp = new ArrayList<Integer>();
		weightTmp.add(0);
		Integer sum = 0;
		for( Integer d : weight ){
			sum += d;
			weightTmp.add(sum);
		}
		Random random = new Random();
		int rand = random.nextInt(sum);
		int index = 0;
		for(int i = weightTmp.size()-1; i >0; i--){
			if( rand >= weightTmp.get(i)){
				index = i;
				break;
			}
		}
		return index;
	}


	//生成固定缺勤同学以及他们的缺的课次
	public Map<Integer,List<Integer>> function1(){
		this.setFixed_absent_num(this.get_fixed_absent_num());
		//创建hashmap
		Map<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
		//创建随机数对象
		Random r = new Random();
		//分配权重
		List<Integer> weight=new ArrayList<Integer>();
		for(int i=1;i<=90;i++){
			if(i<=50) weight.add(1);
			if(i>50&&i<=60) weight.add(5);
			if(i>60&&i<=70) weight.add(10);
			if(i>70) weight.add(40);
		}
		//按权重生成固定缺勤的学生id，不重复
		int index = 0;//index用来做索引值用于数组的迭代
		while(index<fixed_absent_num){

			//从1-90中随机生成
			int id=random(weight);
			for(int i=0;i<index;i++) {
				if(id==absent_stu_id.get(i)) {
					//如果生成的随机数已经存在，重新生成
					id=random(weight);
					i=-1;
				}
			}
			//如果数组中没有重复的元素就放入数组内 并且索引值++
			absent_stu_id.add(index++,id);
		}
		//对缺勤学生ran16个课次
		for(int j=0;j<fixed_absent_num;j++) {
			//创建数组
			List<Integer> putlist=new ArrayList<>();
			//创建排序集合
			Set<Integer> set = new TreeSet<Integer>();
			while (set.size()<16) {
				//产生一个随机数，添加到集合
				//从1-20中生成一个随机数
				int number = r.nextInt(20) + 1;
				set.add(number);
			}
			//遍历集合
			for(Integer i : set) {
				putlist.add(i);

			}
			map.put(absent_stu_id.get(j), putlist);
		}
		return map;
	}
	//生成20次课中每次课额外缺勤的学生id
	public Map<Integer,List<Integer>> function2 (){
		//创建hashmap
		Map<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
		//创建随机数对象
		Random r = new Random();
		//分配权重
		List<Integer> weight=new ArrayList<Integer>();
		for(int i=1;i<=90;i++){
			if(i<=50) weight.add(1);
			if(i>50&&i<=60) weight.add(5);
			if(i>60&&i<=70) weight.add(10);
			if(i>70) weight.add(40);
		}
		for(int j=1;j<21;j++) {
			//创建排序集合
			Set<Integer> set = new TreeSet<Integer>();
			//从0-3生成一个随机数
			int absent_num= r.nextInt(4);
			while (set.size()<absent_num) {
				//产生一个随机数，添加到集合
				int number = random(weight);
				for(int i=0;i<fixed_absent_num;i++) {
					if(number==absent_stu_id.get(i)) {
						//如果生成的学生id是固定缺课的学生，重新生成
						number = random(weight);
						i=-1;
					}
				}
				set.add(number);
			}
			//遍历集合
			List<Integer> putlist = new ArrayList<>(set);
			map.put(j, putlist);
		}
		return map;
	}
}
