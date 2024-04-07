<template>
  <div class="blog-container">
    <CommonHeadImage :message="message" />
    <Row type="flex" class="contents">
      <Col :span="24" :md="16" class="blog-list">
        <div
          class="blog-content"
          v-for="article in pageVO.results"
          :key="article.slug"
        >
          <NuxtLink :to="`/blog/${article.id}`" class="blog-title">
            {{ article.title }}
          </NuxtLink>
          <div class="blog-publish-info">
            <span class="author">sofency</span>
            <span class="divider">•</span>
            <span class="tags">{{ article.tagList }}</span>
            <span class="divider">•</span>
            <time class="pushlish-time">{{ article.createTime }}</time>
          </div>
          <div class="blog-intro">
            <div class="blog-intro-ellipsis">
              {{ article.content }}
            </div>
          </div>
        </div>
        <div>
          <a-pagination
            :current="current"
            :pageSize="pageSize"
            :total="total"
            :hideOnSinglePage="true"
            @change="handlePageChange"
            :showPrevNextButtons="true"
          >
            <template #itemRender="{ page, type }">
              <a v-if="type === 'prev'">Previous</a>
              <a v-else-if="type === 'next'">Next</a>
              <span v-else>{{ page }}</span>
            </template>
          </a-pagination>
        </div>
      </Col>
      <Col :span="24" :md="8" class="sidebar">
        <div class="blog-info">
          <h2>博客信息</h2>
          <div class="info-detail">
            <div class="item">
              <div class="left">站长:</div>
              <div class="right">sofency</div>
            </div>
            <div class="item">
              <div class="left">文章总数:</div>
              <div class="right">123</div>
            </div>
            <div class="item">
              <div class="left">标签总数:</div>
              <div class="right">123</div>
            </div>
            <div class="item">
              <div class="left">评论总数:</div>
              <div class="right">123</div>
            </div>
            <div class="item">
              <div class="left">运行天数:</div>
              <div class="right">3个月</div>
            </div>
          </div>
        </div>
        <div class="blog-info">
          <h2>标签云</h2>
          <div class="tag-cloud">
            <span class="tag tag-level-1">标签1</span>
            <span class="tag tag-level-2">标签2</span>
            <span class="tag tag-level-3">标签3</span>
            <span class="tag tag-level-1">标签4</span>
            <span class="tag tag-level-2">标签5</span>
            <span class="tag tag-level-2">标签5</span>
            <span class="tag tag-level-2">标签5</span>
            <span class="tag tag-level-2">标签5</span>
            <span class="tag tag-level-2">标签5</span>
            <span class="tag tag-level-2">标签5</span>
            <span class="tag tag-level-2">标签5</span>
            <span class="tag tag-level-2">标签5</span>
            <span class="tag tag-level-2">标签5</span>
            <span class="tag tag-level-2">标签5</span>
            <span class="tag tag-level-2">标签5</span>
            <span class="tag tag-level-2">标签5</span>
            <!-- 更多标签... -->
          </div>
        </div>

        <div class="blog-info">
          <h2>访问统计</h2>
          <div class="about-statistic">
            <div class="card-content">
              <div class="statistic">
                <div><span>今日人数</span><span id="今日人数">50</span></div>
                <div><span>今日访问</span><span id="今日访问">64</span></div>
                <div><span>昨日人数</span><span id="昨日人数">51</span></div>
                <div><span>昨日访问</span><span id="昨日访问">72</span></div>
                <div><span>本月访问</span><span id="本月访问">765</span></div>
              </div>
            </div>
          </div>
        </div>
      </Col>
    </Row>
  </div>
</template>
<script>
import CommonHeadImage from "./CommonHeadImage.vue";
import { Row, Col, Pagination } from "ant-design-vue";
export default {
  components: { CommonHeadImage, Row, Col },
  data() {
    return {
      message: "Hello World",
      current: this.pageVO.current,
      pageSize: this.pageVO.page,
      total: this.pageVO.total,
    };
  },
  props: {
    pageVO: { type: Object, required: true },
  },

  methods: {
    handlePageChange(page) {
      this.current = page;
      this.$emit("page-changed", page);
    },
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
  .sidebar {
    .blog-info {
      border: 2px solid #f5f5f6;
      padding: 10px 30px;
      border-radius: 10px;
      margin-left: 50px;
      margin-bottom: 30px;

      .about-statistic {
        min-height: 380px;
        background-size: cover;
        overflow: hidden;
        border-radius: 24px;
        background: var(--card-bg);
        border: transparent;
        box-shadow: 0 8px 16px -4px #2c2d300c;
        position: relative;
        overflow: hidden;
        transition: all 1s;
        .card-content {
          position: absolute;
          width: 100%;
          height: 100%;
          top: 0;
          left: 0;
          z-index: 2;
          display: flex;
          flex-direction: column;
          .statistic {
            border-radius: 15px;
            width: 100%;
            // color: #fff;
            display: flex;
            justify-content: space-between;
            flex-direction: row;
            flex-wrap: wrap;
            margin-top: 1rem;
            margin-bottom: 2rem;
            div {
              display: flex;
              justify-content: space-between;
              flex-direction: column;
              width: 50%;
              margin-bottom: 0.5rem;

              span:last-child {
                font-weight: 700;
                font-size: 34px;
                line-height: 1;
                white-space: nowrap;
              }
            }
          }
        }
      }

      .tag-cloud {
        display: flex;
        flex-wrap: wrap;
        align-items: center;
        gap: 10px; /* 使用 gap 属性设置标签之间的间距 */
      }
      .tag {
        display: inline-flex;
        align-items: center;
        justify-content: center;
        padding: 5px 10px;
        border-radius: 5px;
        background-color: #f0f0f0;
        color: #333;
        font-size: 14px;
        font-weight: bold;
        text-transform: uppercase; /* 所有标签文本大写 */
        transition: background-color 0.3s ease, transform 0.3s ease;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* 添加阴影效果 */
      }
      .tag:hover {
        background-color: #ddd;
      }
      .tag-level-1 {
        font-size: 18px;
      }
      .tag-level-2 {
        font-size: 16px;
      }
      .tag-level-3 {
        font-size: 14px;
      }

      .info-detail {
        .item {
          display: flex;
          justify-content: space-between;
          align-items: center; /* 如果需要垂直居中 */
          height: 30px;
          line-height: 30px;
          border-bottom: 1px solid #f5f5f6;
          .right {
            margin-right: 10px;
          }
        }
      }
    }
  }
}
</style>