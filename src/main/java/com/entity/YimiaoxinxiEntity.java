package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 疫苗信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-04-13 11:07:15
 */
@TableName("yimiaoxinxi")
public class YimiaoxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YimiaoxinxiEntity() {
		
	}
	
	public YimiaoxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 疫苗名称
	 */
					
	private String yimiaomingcheng;
	
	/**
	 * 封面图片
	 */
					
	private String fengmiantupian;
	
	/**
	 * 疫苗分类
	 */
					
	private String yimiaofenlei;
	
	/**
	 * 接种费用
	 */
					
	private Integer jiezhongfeiyong;
	
	/**
	 * 疫苗数量
	 */
					
	private Integer yimiaoshuliang;
	
	/**
	 * 适合人群
	 */
					
	private String shiherenqun;
	
	/**
	 * 接种地点
	 */
					
	private String jiezhongdidian;
	
	/**
	 * 接种时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date jiezhongshijian;
	
	/**
	 * 详情
	 */
					
	private String xiangqing;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：疫苗名称
	 */
	public void setYimiaomingcheng(String yimiaomingcheng) {
		this.yimiaomingcheng = yimiaomingcheng;
	}
	/**
	 * 获取：疫苗名称
	 */
	public String getYimiaomingcheng() {
		return yimiaomingcheng;
	}
	/**
	 * 设置：封面图片
	 */
	public void setFengmiantupian(String fengmiantupian) {
		this.fengmiantupian = fengmiantupian;
	}
	/**
	 * 获取：封面图片
	 */
	public String getFengmiantupian() {
		return fengmiantupian;
	}
	/**
	 * 设置：疫苗分类
	 */
	public void setYimiaofenlei(String yimiaofenlei) {
		this.yimiaofenlei = yimiaofenlei;
	}
	/**
	 * 获取：疫苗分类
	 */
	public String getYimiaofenlei() {
		return yimiaofenlei;
	}
	/**
	 * 设置：接种费用
	 */
	public void setJiezhongfeiyong(Integer jiezhongfeiyong) {
		this.jiezhongfeiyong = jiezhongfeiyong;
	}
	/**
	 * 获取：接种费用
	 */
	public Integer getJiezhongfeiyong() {
		return jiezhongfeiyong;
	}
	/**
	 * 设置：疫苗数量
	 */
	public void setYimiaoshuliang(Integer yimiaoshuliang) {
		this.yimiaoshuliang = yimiaoshuliang;
	}
	/**
	 * 获取：疫苗数量
	 */
	public Integer getYimiaoshuliang() {
		return yimiaoshuliang;
	}
	/**
	 * 设置：适合人群
	 */
	public void setShiherenqun(String shiherenqun) {
		this.shiherenqun = shiherenqun;
	}
	/**
	 * 获取：适合人群
	 */
	public String getShiherenqun() {
		return shiherenqun;
	}
	/**
	 * 设置：接种地点
	 */
	public void setJiezhongdidian(String jiezhongdidian) {
		this.jiezhongdidian = jiezhongdidian;
	}
	/**
	 * 获取：接种地点
	 */
	public String getJiezhongdidian() {
		return jiezhongdidian;
	}
	/**
	 * 设置：接种时间
	 */
	public void setJiezhongshijian(Date jiezhongshijian) {
		this.jiezhongshijian = jiezhongshijian;
	}
	/**
	 * 获取：接种时间
	 */
	public Date getJiezhongshijian() {
		return jiezhongshijian;
	}
	/**
	 * 设置：详情
	 */
	public void setXiangqing(String xiangqing) {
		this.xiangqing = xiangqing;
	}
	/**
	 * 获取：详情
	 */
	public String getXiangqing() {
		return xiangqing;
	}

}
