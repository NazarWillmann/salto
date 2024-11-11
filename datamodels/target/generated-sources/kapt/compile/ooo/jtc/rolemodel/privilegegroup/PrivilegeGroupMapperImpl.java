package ooo.jtc.rolemodel.privilegegroup;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ooo.jtc.rolemodel.accessobject.AccessObject;
import ooo.jtc.rolemodel.accessobject.AccessObjectBuilder;
import ooo.jtc.rolemodel.accessobject.AccessObjectDto;
import ooo.jtc.rolemodel.accessobject.AccessObjectDtoBuilder;
import ooo.jtc.rolemodel.privilege.Privilege;
import ooo.jtc.rolemodel.privilege.PrivilegeBuilder;
import ooo.jtc.rolemodel.privilege.PrivilegeDto;
import ooo.jtc.rolemodel.privilege.PrivilegeDtoBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:40+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class PrivilegeGroupMapperImpl implements PrivilegeGroupMapper {

    @Override
    public PrivilegeGroup toDomainModel(PrivilegeGroupDto dto) {
        if ( dto == null ) {
            return null;
        }

        PrivilegeGroupBuilder privilegeGroup = PrivilegeGroupBuilder.builder();

        privilegeGroup.setId( dto.getId() );
        privilegeGroup.setVersion( dto.getVersion() );
        privilegeGroup.setName( dto.getName() );
        privilegeGroup.setDescription( dto.getDescription() );
        privilegeGroup.setGroups( privilegeGroupDtoListToPrivilegeGroupList( dto.getGroups() ) );
        privilegeGroup.setPrivileges( privilegeDtoListToPrivilegeList( dto.getPrivileges() ) );

        return privilegeGroup.create();
    }

    @Override
    public PrivilegeGroupDto toDto(PrivilegeGroup domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        PrivilegeGroupDtoBuilder privilegeGroupDto = PrivilegeGroupDtoBuilder.builder();

        privilegeGroupDto.setId( domainModel.getId() );
        privilegeGroupDto.setVersion( domainModel.getVersion() );
        privilegeGroupDto.setName( domainModel.getName() );
        privilegeGroupDto.setDescription( domainModel.getDescription() );
        privilegeGroupDto.setGroups( privilegeGroupListToPrivilegeGroupDtoList( domainModel.getGroups() ) );
        privilegeGroupDto.setPrivileges( privilegeListToPrivilegeDtoList( domainModel.getPrivileges() ) );

        return privilegeGroupDto.create();
    }

    protected List<PrivilegeGroup> privilegeGroupDtoListToPrivilegeGroupList(List<PrivilegeGroupDto> list) {
        if ( list == null ) {
            return null;
        }

        List<PrivilegeGroup> list1 = new ArrayList<PrivilegeGroup>( list.size() );
        for ( PrivilegeGroupDto privilegeGroupDto : list ) {
            list1.add( toDomainModel( privilegeGroupDto ) );
        }

        return list1;
    }

    protected AccessObject accessObjectDtoToAccessObject(AccessObjectDto accessObjectDto) {
        if ( accessObjectDto == null ) {
            return null;
        }

        AccessObjectBuilder accessObject = AccessObjectBuilder.builder();

        accessObject.setId( accessObjectDto.getId() );
        accessObject.setVersion( accessObjectDto.getVersion() );
        accessObject.setName( accessObjectDto.getName() );
        accessObject.setUiName( accessObjectDto.getUiName() );
        accessObject.setDescription( accessObjectDto.getDescription() );
        accessObject.setObjectTypeId( accessObjectDto.getObjectTypeId() );
        accessObject.setProductId( accessObjectDto.getProductId() );
        accessObject.setPath( accessObjectDto.getPath() );
        accessObject.setHasControls( accessObjectDto.getHasControls() );

        return accessObject.create();
    }

    protected Privilege privilegeDtoToPrivilege(PrivilegeDto privilegeDto) {
        if ( privilegeDto == null ) {
            return null;
        }

        PrivilegeBuilder privilege = PrivilegeBuilder.builder();

        privilege.setId( privilegeDto.getId() );
        privilege.setVersion( privilegeDto.getVersion() );
        privilege.setName( privilegeDto.getName() );
        privilege.setUiName( privilegeDto.getUiName() );
        privilege.setDescription( privilegeDto.getDescription() );
        privilege.setAccessObjectId( privilegeDto.getAccessObjectId() );
        privilege.setAccessObject( accessObjectDtoToAccessObject( privilegeDto.getAccessObject() ) );

        return privilege.create();
    }

    protected List<Privilege> privilegeDtoListToPrivilegeList(List<PrivilegeDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Privilege> list1 = new ArrayList<Privilege>( list.size() );
        for ( PrivilegeDto privilegeDto : list ) {
            list1.add( privilegeDtoToPrivilege( privilegeDto ) );
        }

        return list1;
    }

    protected List<PrivilegeGroupDto> privilegeGroupListToPrivilegeGroupDtoList(List<PrivilegeGroup> list) {
        if ( list == null ) {
            return null;
        }

        List<PrivilegeGroupDto> list1 = new ArrayList<PrivilegeGroupDto>( list.size() );
        for ( PrivilegeGroup privilegeGroup : list ) {
            list1.add( toDto( privilegeGroup ) );
        }

        return list1;
    }

    protected AccessObjectDto accessObjectToAccessObjectDto(AccessObject accessObject) {
        if ( accessObject == null ) {
            return null;
        }

        AccessObjectDtoBuilder accessObjectDto = AccessObjectDtoBuilder.builder();

        accessObjectDto.setId( accessObject.getId() );
        accessObjectDto.setVersion( accessObject.getVersion() );
        accessObjectDto.setName( accessObject.getName() );
        accessObjectDto.setUiName( accessObject.getUiName() );
        accessObjectDto.setDescription( accessObject.getDescription() );
        accessObjectDto.setObjectTypeId( accessObject.getObjectTypeId() );
        accessObjectDto.setProductId( accessObject.getProductId() );
        accessObjectDto.setPath( accessObject.getPath() );
        accessObjectDto.setHasControls( accessObject.getHasControls() );

        return accessObjectDto.create();
    }

    protected PrivilegeDto privilegeToPrivilegeDto(Privilege privilege) {
        if ( privilege == null ) {
            return null;
        }

        PrivilegeDtoBuilder privilegeDto = PrivilegeDtoBuilder.builder();

        privilegeDto.setId( privilege.getId() );
        privilegeDto.setVersion( privilege.getVersion() );
        privilegeDto.setName( privilege.getName() );
        privilegeDto.setUiName( privilege.getUiName() );
        privilegeDto.setDescription( privilege.getDescription() );
        privilegeDto.setAccessObjectId( privilege.getAccessObjectId() );
        privilegeDto.setAccessObject( accessObjectToAccessObjectDto( privilege.getAccessObject() ) );

        return privilegeDto.create();
    }

    protected List<PrivilegeDto> privilegeListToPrivilegeDtoList(List<Privilege> list) {
        if ( list == null ) {
            return null;
        }

        List<PrivilegeDto> list1 = new ArrayList<PrivilegeDto>( list.size() );
        for ( Privilege privilege : list ) {
            list1.add( privilegeToPrivilegeDto( privilege ) );
        }

        return list1;
    }
}
