package mykotlinpackage.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.manosbatsis.scrudbeans.api.domain.KPersistable
import com.github.manosbatsis.scrudbeans.api.mdd.annotation.model.ScrudBean
import com.github.manosbatsis.scrudbeans.validation.Unique
import mykotlinpackage.dto.OrderUpdateEmailDTO
import org.hibernate.annotations.GenericGenerator
import org.javers.core.metamodel.annotation.DiffIgnore
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Unique
@Table(name = "product_orders")
@EntityListeners(AuditingEntityListener::class)
@ScrudBean(dtoTypes = [OrderUpdateEmailDTO::class], dtoTypeNames = ["mykotlinpackage.dto.OrderUpdateCommentDTO"])
////@ApiModel(value = "Order", description = "A model representing an order of product items")
data class Order(

        @field:Id
        @field:GeneratedValue(generator = "system-uuid")
        @field:GenericGenerator(name = "system-uuid", strategy = "uuid2")
        override var id: String? = null,

        @field:NotNull
        @field:Column(nullable = false)
       // @field:ApiModelProperty(value = "The client's email", required = true)
        var email: String? = null,

        @field:Column(length = 512)
       // @field:ApiModelProperty(value = "Oder comment", required = false)
        var comment: String? = null,

        @field:CreatedDate
        @field:DiffIgnore
        @field:DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        @field:JsonProperty(access = JsonProperty.Access.READ_ONLY)
       // @field:ApiModelProperty(value = "Date created", readOnly = true)
        @field:Column(name = "date_created", nullable = false, updatable = false)
        var createdDate: LocalDateTime? = null,

        @field:LastModifiedDate
        @field:DiffIgnore
        @field:DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        @field:JsonProperty(access = JsonProperty.Access.READ_ONLY)
       // @field:ApiModelProperty(value = "Date last modified", readOnly = true)
        @field:Column(name = "date_last_modified", nullable = false)
        var lastModifiedDate: LocalDateTime? = null


) : KPersistable<String> {
        override fun isNew(): Boolean = id == null
}