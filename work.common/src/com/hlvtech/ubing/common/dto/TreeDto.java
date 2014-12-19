package com.hlvtech.ubing.common.dto;
/**
 * 树dto
 * @author zhangxujun
 * 
 *
 */
public class TreeDto {
    
    /**
     * 自己id
     */
    private Long id;
    
    /**
     * 父id
     */
    private Long pid;
    
    /**
     * 名称
     */
    private String name;
    
    /**
     * 是否选中
     */
    private boolean selected;
    
    
    /**
     * 能否选择
     */
    private boolean selectable;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Long getPid() {
        return pid;
    }


    public void setPid(Long pid) {
        this.pid = pid;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public boolean isSelected() {
        return selected;
    }


    public void setSelected(boolean selected) {
        this.selected = selected;
    }


    public boolean isSelectable() {
        return selectable;
    }


    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }
}
