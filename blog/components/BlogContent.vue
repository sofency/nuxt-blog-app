<template>
  <div class="blog-container">
    <CommonHeadImage :message="message" />
    <Row :type="flex" class="contents">
      <Col :span="24" :md="16" class="blog-list">
        <div
          class="blog-content"
          v-for="article in articles"
          :key="article.slug"
        >
          <NuxtLink to="/blog/spring" class="blog-title">
            {{ article.title }}
          </NuxtLink>
          <div class="blog-publish-info">
            <span class="author">{{ article.author }}</span>
            <span class="divider">•</span>
            <span class="tags">{{ article.tags }}</span>
            <span class="divider">•</span>
            <time class="pushlish-time">{{ article.publish_time }}</time>
          </div>
          <div class="blog-intro">
            <div class="blog-intro-ellipsis">
              {{ article.description }}
            </div>
          </div>
        </div>
      </Col>
      <Col :span="24" :md="8" class="sidebar">推荐列表信息</Col>
    </Row>
  </div>
</template>
<script>
import CommonHeadImage from "./CommonHeadImage.vue";
import { Row, Col } from "ant-design-vue";
export default {
  components: { CommonHeadImage, Row, Col },
  data() {
    return {
      message: "Hello World",
    };
  },
  props: {
    articles: { type: Array, required: true },
  },
};
</script>
<style scoped lang="less">
.blog-container {
  .contents {
    padding-left: 100px;
    padding-right: 100px;

    .blog-list {
      margin-top: 30px;
      padding-top: 10px;
      .blog-content {
        border-bottom: 1px solid #eee;
        margin-bottom: 15px;
        background-color: white;

        .blog-title {
          font-size: 25px;
          font-weight: 400;
          color: #373737;
        }
        .blog-publish-info {
          margin-bottom: 5px;
          margin-top: 5px;
          color: #999;
          font-size: 12px;
          .author {
            color: #337ab7;
          }
          .divider {
            margin: 0 3px;
          }
        }
        .blog-intro {
          font-size: 18px;
          margin-bottom: 10px;
          padding-bottom: 10pxs;
          height: 60px;
          .blog-intro-ellipsis {
            overflow: hidden;
            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-line-clamp: 2; /* 避免换行 */
            -webkit-box-orient: vertical;
          }
        }
      }
    }

    .sidebar {
      margin-top: 30px;
      padding-top: 10px;
    }
  }
}
</style>