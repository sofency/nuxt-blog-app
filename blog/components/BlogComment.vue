<template>
  <div class="comment-container">
    <div class="comment-info">
      <div class="comment-title">
        <h3>评论内容</h3>
      </div>
      <div ref="replyBox">
        <Row type="flex" class="comment-input">
          <Col :span="0" :lg="2" class="comment-input-img">
            <img src="/img/avatar.jpeg" alt="avatar" />
          </Col>
          <Col :span="24" :lg="20" class="comment-dialog">
            <textarea
              name="message"
              id="comment-content"
              ref="commentContent"
            ></textarea>
            <a-button class="submit" @click="submitComment">提交评论</a-button>

            <Row type="flex" class="require-info">
              <Col :span="24" :lg="8" class="info">
                <label for="nickname">昵称:</label>
                <input
                  placeholder="用户昵称"
                  id="nickname"
                  v-model="nickname"
                />
              </Col>
              <Col :span="24" :lg="8" class="info">
                <label for="email">邮箱:</label>
                <input
                  placeholder="仅用于接收消息"
                  id="email"
                  v-model="email"
                />
              </Col>
              <Col :span="24" :lg="8" class="info">
                <label for="website">网址:</label>
                <input placeholder="您的网址" id="website" v-model="website" />
              </Col>
            </Row>
          </Col>
        </Row>
      </div>

      <Row
        type="flex"
        class="comment-detail"
        v-for="(comment, index) in comments"
        :key="index"
      >
        <Col :span="2" :lg="2" class="comment-input-img">
          <img src="/img/avatar.jpeg" alt="avatar" />
        </Col>
        <Col :span="22" :lg="22" class="comment-input-img">
          <div class="user-comment-info">
            <div>
              <span class="user-name">sofency</span>
              <span class="publish-time text-color">{{
                comment.parentComment.createTime
              }}</span>
              <span class="comment-ip text-color"
                >IP属地: {{ comment.parentComment.ipAddress }}</span
              >
              <button
                class="reply text-color"
                @click="reply(comment.parentComment.id, null, 0)"
              >
                回复
              </button>
            </div>
            <div class="message">
              {{ comment.parentComment.content }}
            </div>
            <!-- 子评论 -->
            <Row
              type="flex"
              class="second-comment"
              v-for="(child, child_index) in comment.childComment"
              :key="child_index"
            >
              <Col :span="2" :lg="2" class="comment-input-img">
                <img src="/img/avatar.jpeg" alt="avatar" />
              </Col>
              <Col :span="22" :lg="22">
                <div>
                  <span class="user-name" v-if="child.replyName == null">{{
                    child.username
                  }}</span>
                  <span class="user-name" v-else
                    >{{ child.username }} @ {{ child.replyName }}</span
                  >

                  <span class="publish-time text-color">{{
                    child.createTime
                  }}</span>
                  <span class="comment-ip text-color"
                    >IP属地: {{ child.ipAddress }}</span
                  >
                  <button
                    class="reply text-color"
                    @click="reply(comment.parentComment.id, child.id, 1)"
                  >
                    回复
                  </button>
                </div>

                <div class="message">
                  {{ child.content }}
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
import Cookies from "js-cookie";
import { Row, Col } from "ant-design-vue";
import $ from "jquery";
export default {
  components: { Row, Col },
  props: {
    comments: Array,
  },
  data() {
    return {
      isLogin: false,
      replyCommentId: null,
      parentCommentId: null,
      type: 0,
      nickname: "",
      email: "",
      website: "",
    };
  },
  mounted() {
    var user = Cookies.get("user");
    const userData = user ? JSON.parse(user) : null;

    if (userData) {
      // 如果存在用户名，则设置到data中的username，进而通过v-model反映到input上
      this.nickname = userData.nickname;
      this.email = userData.email;
      this.website = userData.website;
    }
  },
  methods: {
    reply(parentCommentId, replyCommentId, type) {
      this.parentCommentId = parentCommentId;
      if (type == 1) {
        this.replyCommentId = replyCommentId;
      }
      console.log(parentCommentId, replyCommentId);
      const replyBox = this.$refs.replyBox;
      replyBox.scrollIntoView({ behavior: "smooth" }); // 滚动到评论框位置

      // 等待滚动完成后，再额外滚动 30px
      this.$nextTick(() => {
        const currentScrollPosition =
          window.pageYOffset || document.documentElement.scrollTop;
        const replyBoxOffsetTop = replyBox.offsetTop;
        const targetScrollPosition =
          replyBoxOffsetTop - currentScrollPosition + 30; // 加上 30px 的偏移

        // 平滑滚动到目标位置
        window.scrollTo({
          top: targetScrollPosition,
          behavior: "smooth",
        });
        const commentContent = this.$refs.commentContent;
        // 设置焦点
        commentContent.focus();
      });
    },
    submitComment() {
      var nickname = $("#nickname").val();
      var email = $("#email").val();
      var website = $("#website").val();

      var content = $("#comment-content").val();
      this.$axios({
        url: "/api/blog/comment",
        method: "post",
        data: {
          user: {
            nickname: nickname,
            email: email,
            website: website,
          },
          comment: {
            content: content,
            blogId: this.$route.params.slug,
            replyCommentId: this.replyCommentId,
            parentId: this.parentCommentId,
          },
        },
      }).then((res) => {
        Cookies.set("user", JSON.stringify(res.data.data));
      });
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
  margin-bottom: 20px;
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

.message {
  margin-top: 10px;
}
</style>