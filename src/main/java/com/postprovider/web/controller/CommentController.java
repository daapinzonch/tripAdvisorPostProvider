package com.postprovider.web.controller;


import com.postprovider.web.entity.Comment;
import com.postprovider.web.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(value="Comments", produces = "application/json", description = "Comments made by the users associated to the provider posts.")
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ApiOperation(value = "Get all the comments of a given Post by its Id." , response = List.class)
    @GetMapping ("/{id}")
    public ResponseEntity<List<Comment>> getCommentsOfPost(
            @ApiParam(value = "Post's ID of which the comments are requested.", required = true)
            @PathVariable ("id") String id){
        return ResponseEntity.ok(this.commentService.getCommentsOfPostById(id));
    }


    @ApiOperation(value = "Create and post a new comment of a given Post by its Id." , response = String.class)
    @PutMapping ("/{postId}")
    public ResponseEntity<String> createComment(
            @ApiParam(value = "Post's ID in which the comment will be submitted.")
            @PathVariable ("postId") String postId,
            @ApiParam(value = "Comment to be added.")
            @RequestBody Comment comment){
       try{
            String commentId = commentService.saveComment(postId, comment);
            if(commentId == null){
                return new ResponseEntity<>( "-1" , HttpStatus.BAD_REQUEST);
            }
            else{
                return new ResponseEntity<>( commentId , HttpStatus.CREATED);
            }


       }catch (Exception e){
           return new ResponseEntity<>( e.toString()  , HttpStatus.FORBIDDEN);
       }
    }

    @ApiOperation(value = "Delete a comment by Id, of a given Post by its Id." , response = String.class)
    @DeleteMapping ("/")
    public ResponseEntity<String> deleteComment(
            @ApiParam(value = "Post's ID of which the comment are going to be deleted.") @RequestParam String postId,
            @ApiParam(value = "Comment's ID to be deleted.") @RequestParam String commentId)
    {
        try{
            String s = commentService.deleteComment(postId, commentId);
            if( s== null){
                return new ResponseEntity<>( commentId , HttpStatus.BAD_REQUEST);
            }else{
                return new ResponseEntity<>( commentId , HttpStatus.ACCEPTED);
            }
        }catch(Exception e){
            return new ResponseEntity<>( e.toString() , HttpStatus.FORBIDDEN);
        }
    }
}
