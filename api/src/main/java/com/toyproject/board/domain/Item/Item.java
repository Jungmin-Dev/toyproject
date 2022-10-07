package com.toyproject.board.domain.Item;

import com.toyproject.board.domain.Upload.UploadFile;
import lombok.Data;

import java.util.List;

@Data
public class Item {

    private Long id;
    private String itemName;
    private UploadFile attachFile;
    private List<UploadFile> imageFiles;
}
