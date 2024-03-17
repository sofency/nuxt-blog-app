<template>
  <div class="comment-container">
    <div class="comment-info">
      <div class="comment-title">
        <h3>评论内容</h3>
      </div>
      <Row :type="flex" class="comment-input">
        <Col :span="0" :lg="2" class="comment-input-img">
          <img src="/img/avatar.jpeg" alt="avatar" />
        </Col>
        <Col :span="24" :lg="20" class="comment-dialog">
          <textarea name="message" id=""></textarea>
          <a-button class="submit">提交评论</a-button>

          <Row :type="flex" class="require-info">
            <Col :span="24" :lg="8" class="info">
              <label for="username">昵称:</label>
              <input placeholder="用户昵称" id="username" />
            </Col>
            <Col :span="24" :lg="8" class="info">
              <label for="email">邮箱:</label>
              <input placeholder="仅用于接收消息" id="email" />
            </Col>
            <Col :span="24" :lg="8" class="info">
              <label for="website">网址:</label>
              <input placeholder="您的网址" id="website" />
            </Col>
          </Row>
        </Col>
      </Row>

      <Row :type="flex" class="comment-detail">
        <Col :span="2" :lg="2" class="comment-input-img">
          <img src="/img/avatar.jpeg" alt="avatar" />
        </Col>
        <Col :span="22" :lg="22" class="comment-input-img">
          <div class="user-comment-info">
            <div>
              <span class="user-name">sofency</span>
              <span class="publish-time text-color">2023年8月8日</span>
              <span class="comment-ip text-color">IP属地: 湖北</span>
              <button class="reply text-color" @click="reply">回复</button>
            </div>
            <div class="message">
              Lorem ipsum dolor sit amet consectetur, adipisicing elit.
              Accusantium in eligendi perferendis quis, deserunt harum quasi ea
              similique iste laboriosam itaque dignissimos assumenda molestiae
              impedit quidem. Eveniet similique nesciunt saepe!
            </div>
            <Row :type="flex" class="second-comment">
              <Col :span="2" :lg="2" class="comment-input-img">
                <img src="/img/avatar.jpeg" alt="avatar" />
              </Col>
              <Col :span="22" :lg="22">
                <div>
                  <span class="user-name">sofency @ alice</span>
                  <span class="publish-time text-color">2023年8月8日</span>
                  <span class="comment-ip text-color">IP属地: 湖北</span>
                  <button class="reply text-color">回复</button>
                </div>

                <div class="message">
                  Lorem ipsum dolor sit amet consectetur, adipisicing elit.
                  Accusantium in eligendi perferendis quis, deserunt harum quasi
                  ea similique iste laboriosam itaque dignissimos assumenda
                  molestiae impedit quidem. Eveniet similique nesciunt saepe!
                </div>
              </Col>
            </Row>
          </div>
        </Col>
      </Row>
    </div>
  </div>
</template>
<script>
import { Row, Col } from "ant-design-vue";
export default {
  components: { Row, Col },
  data() {
    return {
      isLogin: false,
    };
  },

  methods: {
    reply() {
      console.log("测试");
    },
  },
};
</script>
<style scoped lang="less">
.reply {
  margin-left: 10px;
  padding: 0;
  border: none;
  background-color: transparent;
}

.second-comment {
  margin-top: 10px;
  padding-top: 10px;
  border-top: 1px solid #eee;
}
.reply:hover {
  color: cornflowerblue;
}
.text-color {
  color: #98a6ad;
  font-size: 10px;
}
.user-comment-info {
  .user-name {
    font-size: 15px;
  }
  .publish-time {
    margin-left: 20px;
    margin-right: 15px;
  }
}
.comment-detail {
  border-top: 1px solid rgba(222, 229, 231, 0.45);
  padding-top: 10px;
}
.comment-input-img {
  img {
    width: 40px;
    height: 40px;
    border-radius: 50%;
  }
}
.comment-input {
  margin-bottom: 20px;
  .comment-dialog {
    textarea {
      width: 100%;
      height: 80px;
      border-radius: 10px;
      padding: 10px 20px;
    }
    .submit {
      margin-top: 8px;
    }

    .require-info {
      margin-top: 15px;
      justify-content: space-between;

      .info:nth-child(2) {
        text-align: center;
      }
      .info:nth-child(3) {
        text-align: end;
      }
    }
  }
}
</style>