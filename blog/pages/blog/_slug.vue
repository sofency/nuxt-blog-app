<template>
  <div class="article-container">
    <NavHeader />
    <div class="article-view">
      <CommonHeadImage :message="article.title" />
      <Row type="flex" class="article-content">
        <Col :span="0" :lg="4" class="article-info">浏览数据信息</Col>
        <Col :span="24" :lg="16" class="article">
          <div class="article-body">
            <div v-html="parsedMarkdown"></div>
            <div class="reward">
              <div class="img-out">
                <img src="/img/zhJay.png" class="logo" />
              </div>
              <div class="nickname">sofency</div>
              <div class="info">分享技术生活</div>
              <div class="money">
                <div class="show-img">
                  <div>非常感谢</div>
                  <div class="imgs">
                    <div class="item">
                      <img src="/img/QQ.jpg" />
                      <div>QQ</div>
                    </div>
                    <div class="item">
                      <img src="/img/Wechat.jpg" />
                      <div>微信</div>
                    </div>
                  </div>
                </div>
                <div class="ercode">打赏作者</div>
              </div>
              <div class="copyright">
                本文是原创文章,采用CC BY-NC-ND 4.0协议,完整转载请注明来自Sofency
              </div>
            </div>

            <div class="blog-tags">
              <span v-for="tag in article.tagList.split(',')" :key="tag">{{
                tag
              }}</span>
            </div>
          </div>
          <BlogComment :comments="comments" />
        </Col>
      </Row>
    </div>
    <Fotter />
  </div>
</template>

<script>
import NavHeader from "../../components/NavHeader.vue";
import BlogComment from "../../components/BlogComment.vue";
import Fotter from "../../components/Fotter.vue";
import $ from "jquery";
import { Row, Col } from "ant-design-vue";
import handleScroll from "../../static/slip";

export default {
  async asyncData({ $axios, params }) {
    const responseData = await $axios({
      url: `/api/blog/detail/${params.slug}`,
    });
    return {
      article: responseData.data.data.blog,
      comments: responseData.data.data.comments,
    };
  },
  components: { NavHeader, BlogComment, Row, Col, Fotter },
  computed: {
    parsedMarkdown() {
      return this.$md.render(this.article.content);
    },
  },

  head() {
    return {
      title: this.article.title,
      meta: [
        {
          hid: "title",
          name: "title",
          content: this.article.title,
        },
        {
          hid: "og:keywords",
          property: "og:keywords",
          content: this.article.tag,
        },
        // 这里可以添加更多的meta标签根据需求
      ],
    };
  },
  methods: {
    handleDoubleClick() {
      console.log("sasa");
    },
  },

  mounted() {
    $(".ercode").on("mouseenter", function () {
      $(".show-img").css({
        display: "block",
      });
    });

    $(".ercode").on("mouseleave", function () {
      $(".show-img").css({
        display: "none",
      });
    });
    window.addEventListener("scroll", handleScroll);
    // 复制内容追加版权信息
    $(document).on("copy", function () {
      var selectedText = window.getSelection().toString();
      if (selectedText.length > 0) {
        var copyrightText = "版权所有 © 2023 www.sofency.cn";
        var copiedContent = selectedText + "\n" + copyrightText;
        var clipboardData =
          event.clipboardData ||
          window.clipboardData ||
          event.originalEvent.clipboardData;
        clipboardData.setData("text", copiedContent);
        event.preventDefault();
      }
    });
  },
};
</script>

<style scoped lang="less">
.article-content {
  width: 90%;
  margin-left: auto;
  margin-right: auto;
  padding-top: 20px;

  .article {
    background-color: white;
    padding: 10px 20px;
    border-radius: 10px;

    .article-body {
      padding: 10px;
      border-radius: 10px;
      margin-bottom: 40px;

      .reward {
        margin-top: 80px;
        text-align: center;
        background-color: #f7f7f9;
        border-radius: 10px;
        position: relative;
        padding-bottom: 20px;
        .img-out {
          width: 66px;
          height: 66px;
          position: absolute;
          border: 1px solid #e3e8f7;
          border-radius: 50%;
          top: -33px;
          left: calc(50% - 33px);
          .logo {
            width: 100%;
            transition: transform 0.3s ease-in-out; /* 添加过渡效果 */
          }
        }

        .logo:hover {
          transform: scale(0.8); /* 鼠标悬停时缩小到原始尺寸的80% */
        }
        .nickname {
          padding-top: 40px;
          padding-bottom: 10px;
          text-align: center;
          font-size: 20px;
          font-weight: bold;
          color: #363636;
          line-height: 1;
        }
        .info {
          font-size: 14px;
          color: rgba(60, 60, 67, 0.8);
          margin-top: 4px;
        }

        .money {
          position: relative;
          .show-img {
            display: none;
            position: absolute;
            left: calc(50% - 125px);
            top: -180px;
            padding: 10px;
            width: 250px;
            border-radius: 5px;
            background-color: white;
            border: 1px solid;
            .imgs {
              margin-top: 10px;
              margin-left: auto;
              margin-right: auto;
              display: flex;
              justify-content: center;
              .item:first-child {
                margin-right: 20px;
              }
              .item {
                img {
                  width: 100px;
                  height: 100px;
                  padding: 2px;
                  border-radius: 5px;
                }
                img:first-child {
                  border: 1px solid #57bd6a;
                }
                img:last-child {
                  border: 1px solid #425aef;
                }
              }
            }
          }
          .ercode {
            margin: 10px auto;
            background: #f04a63;
            color: #fff;
            padding: 0;
            width: 126px;
            height: 40px;
            line-height: 39px;
            box-shadow: 0 8px 12px -3px #ee7d7936;
          }
        }
        .copyright {
          font-size: 12px;
        }
      }

      .blog-tags {
        margin-top: 20px;
        span {
          display: inline-block;
          border: 1px solid #f0f0f0;
          margin-right: 10px;
          padding: 5px 10px;
          border-radius: 7px;
        }

        span:before {
          content: "#";
          font-size: 14px;
          opacity: 0.4;
        }
        span:hover {
          background-color: #307af6;
          color: white;
        }
      }
    }
  }
}
</style>


