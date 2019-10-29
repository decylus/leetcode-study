package com.decylus.study.t300.k315;

/**
 * Created on 2019-10-28.
 *
 * @author jiawei
 */
public class SegmentTree {

    private int min;

    private int max;

    private int mid;

    private int value;

    private SegmentTree left;

    private SegmentTree right;

    public SegmentTree(int min, int max){
        this.min = min;
        this.max = max;
        this.value = 0;
        if(min == max){
            return;
        }
        this.mid = (min + max) / 2;
        if (min < 0 && max <= 0){
            left = new SegmentTree(min, mid - 1);
            right = new SegmentTree(mid, max);
        }else {
            left = new SegmentTree(min, mid);
            right = new SegmentTree(mid + 1, max);
        }
    }

    public void add(int key){
        if (key < min || key > max){
            return;
        }
        if (key >= min && key <= max){
            value += 1;
        }

        if (key <= mid && left != null){
            left.add(key);
        }
        if (key >= mid && right != null){
            right.add(key);
        }
    }

    public int get(int x, int y){
        if (y < x || y < min || x > max){
            return 0;
        }
        if(x <= min && y >= max){
            return this.value;
        }
        int total = 0;
        if (left != null){
            total += left.get(x, this.mid>y?y:this.mid);
        }
        if (right != null){
            total += right.get(this.mid+1<x?x:this.mid, y);
        }
        return total;
    }


    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMid() {
        return mid;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public SegmentTree getLeft() {
        return left;
    }

    public void setLeft(SegmentTree left) {
        this.left = left;
    }

    public SegmentTree getRight() {
        return right;
    }

    public void setRight(SegmentTree right) {
        this.right = right;
    }
}
