package com.leetcode.innings2023.hard;

import java.util.*;

public class _2254_VideoSharingPlatform {
    private static class Video {
        int videoId;
        int likes;
        int dislikes;
        int views;
        String content;
        public Video(int videoId, String content){
            this.videoId = videoId;
            this.content = content;
            this.likes = this.dislikes = this.views = 0;
        }
    }
    private static final int VIDEO_ID_PREFETCH_SIZE = 100010;

    private final PriorityQueue<Integer> idQueue;
    private final Map<Integer, Video> videos;

    public _2254_VideoSharingPlatform() {
        idQueue = new PriorityQueue<>();
        videos = new HashMap<>();
    }


    public int upload(String video) {
        if(idQueue.isEmpty()){
            idQueue.offer(0);
        } else {
            idQueue.offer(idQueue.peek()+1);
        }
        int videoId = idQueue.poll();
        this.videos.put(videoId, new Video(videoId, video));
        return videoId;
    }

    public void remove(int videoId) {
        if(videos.remove(videoId) != null){
            this.idQueue.offer(videoId);
        }
    }

    public String watch(int videoId, int startMinute, int endMinute) {
        Video video = videos.get(videoId);
        if(video == null){
            return "-1";
        }
        video.views++;
        return video.content.substring(startMinute, Math.min(endMinute, video.content.length()-1) + 1);
    }

    public void like(int videoId) {
        Video video = videos.get(videoId);
        if(video != null){
            video.likes++;
        }
    }

    public void dislike(int videoId) {
        Video video = videos.get(videoId);
        if(video != null){
            video.dislikes++;
        }
    }

    public int[] getLikesAndDislikes(int videoId) {
        Video video = videos.get(videoId);
        if(video == null){
            return new int[]{-1};
        }
        return new int[]{video.likes, video.dislikes};
    }

    public int getViews(int videoId) {
        Video video = videos.get(videoId);
        return video == null ? -1 : video.views;
    }

    public static void main(String[] args) {
        _2254_VideoSharingPlatform videoSharingPlatform = new _2254_VideoSharingPlatform();
        //["upload","like","remove","dislike","getLikesAndDislikes","remove","remove","upload","dislike","watch","getViews","watch","upload","like","remove","getViews","dislike","like","watch","remove","like","dislike","getViews","getViews","watch","getLikesAndDislikes","getViews","getViews","getLikesAndDislikes","watch","getLikesAndDislikes","getLikesAndDislikes","remove","remove","remove","dislike","remove","remove","upload","getLikesAndDislikes","remove","like","like"]
        videoSharingPlatform.remove(17);
        videoSharingPlatform.like(4);
        videoSharingPlatform.dislike(24);
        videoSharingPlatform.dislike(46);
        videoSharingPlatform.upload("160202534312397940");


    }
}

//[null,null,null,null,null,0,null,null,null,[-1],null,null,1,null,"-1",-1,"-1",2,null,null,-1,null,null,"-1",null,null,null,-1,-1,"-1",[-1],-1,-1,[-1],"-1",[-1],[-1],null,null,null,null,null,null,2,[-1],null,null,null]
//[null,null,null,null,null,0,null,null,null,[-1],null,null,1,null,"-1",-1,"-1",2,null,null,-1,null,null,"-1",null,null,null,-1,-1,"-1",[-1],-1,-1,[-1],"-1",[-1],[-1],null,null,null,null,null,null,0,[-1],null,null,null]