package cn.njxz.fitness.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @author yue.wu
 * @Description
 * @date 2020/4/26 17:57
 */
@Component
public class uploadImageUtil {
    //定义图片存储在服务器的路径
    public static final String PICTUREURL = "D:/images/";
    public static final String CONFIGUREURL = "http://10.11.23.203:8029/";
    public String uploadPictureByFile(MultipartFile file) {
        // TODO 自动生成的方法存根
        String filename1 = "picture_" + UUID.randomUUID() + ".jpg";//生成唯一图片路径
        if (!file.isEmpty()) {
            try {
                File filepath = new File(PICTUREURL);
                if (!filepath.exists())
                    filepath.mkdirs();
                // 文件保存路径
                String savePath = PICTUREURL + filename1;
                // 转存文件
                file.transferTo(new File(savePath));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String url = CONFIGUREURL + filename1;
        return url;
    }
}
