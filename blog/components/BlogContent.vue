<template>
  <div class="blog-container">
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
  </div>
</template>
<script>
import CommonHeadImage from "./CommonHeadImage.vue";
import IndexSideBarVue from "./IndexSideBar.vue";
import { Row, Col, Pagination } from "ant-design-vue";
export default {
  components: { CommonHeadImage, Row, Col, IndexSideBarVue },
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
</style>